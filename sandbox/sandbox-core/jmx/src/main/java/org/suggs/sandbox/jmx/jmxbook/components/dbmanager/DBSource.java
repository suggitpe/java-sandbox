/*
 * DBSource.java created on 20 Feb 2008 19:33:31 by suggitpe for project SandBox - JMX
 * 
 */
package org.suggs.sandbox.jmx.jmxbook.components.dbmanager;

import org.suggs.sandbox.jmx.jmxbook.ExceptionUtil;

import java.sql.Connection;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * MBean class to encapsulate a datasource functionality
 * 
 * @author suggitpe
 * @version 1.0 20 Feb 2008
 */
public class DBSource implements DBSourceMBean {

    private static final Log LOG = LogFactory.getLog( DBSource.class );

    private DataSource dataSource;
    private boolean commit = false;

    /**
     * Constructs a new instance.
     * 
     * @param jndiName
     *            the jndi name of the resource
     */
    public DBSource( String jndiName ) {
        resetDataSource( jndiName );
    }

    /**
     * @see org.suggs.sandbox.jmx.jmxbook.components.dbmanager.DBSourceMBean#resetDataSource(java.lang.String)
     */
    @Override
    public final void resetDataSource( String name ) {
        LOG.debug( "Setting the datasource with name [" + name + "]" );
        try {
            Context ctx = new InitialContext();
            dataSource = (DataSource) ctx.lookup( name );
        }
        catch ( Exception e ) {
            LOG.error( "exception caught when looking up the datasource [" + name + "]", e );
        }
    }

    /**
     * @see org.suggs.sandbox.jmx.jmxbook.components.dbmanager.DBSourceMBean#getConnection()
     */
    @Override
    public Connection getConnection() {
        Connection ret;

        try {
            ret = dataSource.getConnection();
            ret.setAutoCommit( commit );
            return ret;
        }
        catch ( Exception e ) {
            ExceptionUtil.printException( e );
        }
        return null;
    }

    /**
     * @see org.suggs.sandbox.jmx.jmxbook.components.dbmanager.DBSourceMBean#getAutoCommit()
     */
    @Override
    public boolean getAutoCommit() {
        return commit;
    }

    /**
     * @see org.suggs.sandbox.jmx.jmxbook.components.dbmanager.DBSourceMBean#setAutoCommit(boolean)
     */
    @Override
    public void setAutoCommit( boolean aCommit ) {
        commit = aCommit;
    }
}
