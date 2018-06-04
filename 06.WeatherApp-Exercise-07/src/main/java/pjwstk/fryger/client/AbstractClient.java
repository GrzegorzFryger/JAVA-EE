package pjwstk.fryger.client;

import pjwstk.fryger.config.ConfigurationResources;
import pjwstk.fryger.config.OpenweathermapResources;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public abstract class AbstractClient <T>
{

    private Client client;
    private WebTarget webTarget;
    private String RESOURCE_URL;
    private String APP_KEY;


    @Inject
    ConfigurationResources configuration;


    @PostConstruct
    private void postConstruct()
    {
        this.RESOURCE_URL = configuration.getUrl();
        this.APP_KEY = configuration.getAppKey();
    }

    public  enum Param {

        ID {
            @Override
            public String toString() {
                return "id";
            }
        },
        Q {
            @Override
            public String toString() {
                return "q";
            }
        },
        ZIP{
            @Override
            public String toString() {
                return "zip";
            }
        }

    }


    protected abstract WebTarget setPath(WebTarget webTarget1);
    protected abstract WebTarget setQueryParm(WebTarget webTarget1,Param param, String valueParam);

    public AbstractClient()
    {
        this.client = ClientBuilder.newClient();

    }


    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public String getRESOURCE_URL() {
        return RESOURCE_URL;
    }

    public void setRESOURCE_URL(String RESOURCE_URL) {
        this.RESOURCE_URL = RESOURCE_URL;
    }

    public String getAPP_KEY() {
        return APP_KEY;
    }

    public void setAPP_KEY(String APP_KEY) {
        this.APP_KEY = APP_KEY;
    }

    public String sentResponse(Param param, String valueParam)
    {




        this.webTarget = client.target(this.RESOURCE_URL);



        Response response  = setQueryParm(setPath(this.webTarget),param,valueParam)
                .queryParam("appid",APP_KEY)
                .request(MediaType.APPLICATION_JSON).get();




        try {
            if (response.getStatus() == 200) {

              return  response.readEntity(String.class);

            }
        } finally {

            response.close();
        }


        return null;
    }




}
