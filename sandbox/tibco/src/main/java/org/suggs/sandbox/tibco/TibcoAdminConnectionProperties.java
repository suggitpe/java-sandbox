/*
 * TibcoAdminConnectionProperties.java created on 6 Aug 2008 18:17:06 by suggitpe for project SandBox - Tibco
 * 
 */
package org.suggs.sandbox.tibco;

import java.io.IOException;
import java.util.Properties;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.tibco.tibjms.admin.TibjmsAdmin;
import com.tibco.tibjms.admin.TibjmsAdminException;

/**
 * Helper class to manage the creation of a Tibco Admin hook
 * 
 * @author suggitpe
 * @version 1.0 6 Aug 2008
 */
public class TibcoAdminConnectionProperties
{

    private static final Log LOG = LogFactory.getLog( TibcoAdminConnectionProperties.class );
    private static final String PROP_FILE = "tibco_connection.properties";

    private static TibcoAdminConnectionProperties mInstance_;
    private Properties mData_;
    private TibjmsAdmin mAdmin_;

    // load up the instance of the properties file
    static
    {
        mInstance_ = new TibcoAdminConnectionProperties();
    }

    /**
     * Instance implementation from which we can get the
     * 
     * @return the instance of the singleton
     */
    public static TibcoAdminConnectionProperties instance()
    {
        return mInstance_;
    }

    /**
     * Constructs a new instance.
     */
    private TibcoAdminConnectionProperties()
    {

        mData_ = new Properties();
        try
        {
            mData_.load( this.getClass().getClassLoader().getResourceAsStream( PROP_FILE ) );
        }
        catch ( IOException ioe )
        {
            throw new IllegalStateException( "Failed to load properties file [" + PROP_FILE + "]" );
        }

        if ( LOG.isDebugEnabled() )
        {
            LOG.debug( "Loaded properties from [" + PROP_FILE + "]" );
        }
    }

    /**
     * Getter for the provider URL
     * 
     * @return the provider URL
     */
    public String getProviderUrl()
    {
        return mData_.getProperty( "provider.url" );
    }

    /**
     * Getter for the user name.
     * 
     * @return the user name.
     */
    public String getUsername()
    {
        return mData_.getProperty( "tibco.username" );
    }

    /**
     * Getter for the password.
     * 
     * @return the password.
     */
    public String getPassword()
    {
        return mData_.getProperty( "tibco.pasword" );
    }

    /**
     * Returns a local instance of the tibco JMS admin object
     * 
     * @return a tibco jms admin object
     */
    public TibjmsAdmin getAdmin()
    {
        synchronized ( this )
        {
            if ( mAdmin_ == null )
            {
                try
                {
                    mAdmin_ = new TibjmsAdmin( getProviderUrl(), getUsername(), getPassword() );
                }
                catch ( TibjmsAdminException tjae )
                {
                    tjae.printStackTrace();
                    throw new IllegalStateException( "Unable to connect to the Tibco EMS broker as admin" );
                }
            }
        }
        return mAdmin_;
    }

}
