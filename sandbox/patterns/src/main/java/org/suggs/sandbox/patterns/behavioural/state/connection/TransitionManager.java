/*
 * TransitionManager.java created on 12 Aug 2009 20:10:52 by suggitpe for project SandBox - Patterns
 * 
 */
package org.suggs.sandbox.patterns.behavioural.state.connection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 * Class to encapsulate the management of all of the transitions. This
 * could allow for externally altered transitions to be injected into
 * the running application.
 * 
 * @author suggitpe
 * @version 1.0 12 Aug 2009
 */
public class TransitionManager
{

    private static final Log LOG = LogFactory.getLog( TransitionManager.class );
    private static final TransitionManager mInstance_ = new TransitionManager();

    // TODO: why store a map of maps as opposed to a map of lists or
    // something else (not sure what feels right here)?
    private Map<String, Map<String, ITransition>> mTransitionMap_ = new HashMap<String, Map<String, ITransition>>();;

    /**
     * Constructs a new instance (private for singleton pattern).
     */
    private TransitionManager()
    {
        super();

        LOG.debug( "Creating a new TransitionManager " + this );
    }

    /**
     * Singleton accessor to the instance
     * 
     * @return the instance of the TransitionManager
     */
    public static final TransitionManager getInstance()
    {
        return mInstance_;
    }

    /**
     * Getter for a state specific list of transitions
     * 
     * @param aState
     *            the state to which the transitions are associated
     * @return a list of transitions that are associated with a given
     *         state
     */
    public List<ITransition> getTranitionsForStartState( IState aState )
    {
        LOG.debug( "Getting all of the available transitions for state [" + aState.getName() + "]" );
        List<ITransition> listOfTransitions = new ArrayList<ITransition>();

        if ( mTransitionMap_.containsKey( aState.getName() ) )
        {
            Map<String, ITransition> mapOfTransitions = mTransitionMap_.get( aState.getName() );
            for ( String s : mapOfTransitions.keySet() )
            {
                listOfTransitions.add( mapOfTransitions.get( s ) );
            }
        }
        return listOfTransitions;
    }

    /**
     * Accessor map to allow for the addition of a single transition
     * 
     * @param aTransition
     *            the transition itself
     */
    public void addTransition( ITransition aTransition )
    {

        String startStateName = aTransition.getStartState().getName();
        // firstly we need to create the inner map if it does not
        // exist
        if ( !mTransitionMap_.keySet().contains( startStateName ) )
        {
            mTransitionMap_.put( startStateName, new HashMap<String, ITransition>() );
        }

        Map<String, ITransition> innerMap = mTransitionMap_.get( startStateName );
        if ( innerMap.containsKey( aTransition.getName() ) )
        {
            throw new IllegalStateException( "Trying to add a transition [" + aTransition.getName()
                                             + "] that already exists for state [" + startStateName
                                             + "].  This is not allowed." );
        }

        innerMap.put( aTransition.getName(), aTransition );

        LOG.debug( "Loaded transition [" + aTransition.getName() + "] for state [" + startStateName
                   + "] successfully." );
    }

    /**
     * Getter for the transitions
     * 
     * @return the transitions
     */
    public List<ITransition> getTransitionList()
    {
        throw new NotImplementedException();
    }

    /**
     * Setter for the transitions
     * 
     * @param aListOfTransitions
     *            a list of transitions
     */
    public void setTransitions( List<ITransition> aListOfTransitions )
    {
        for ( ITransition trans : aListOfTransitions )
        {
            this.addTransition( trans );
        }
    }

    /**
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString()
    {
        StringBuffer ret = new StringBuffer( "TransitionManager: " );
        ret.append( "{" ).append( Integer.toHexString( super.hashCode() ) ).append( "} " );
        ret.append( "numStates=[" ).append( mTransitionMap_.size() ).append( "] " );
        for ( String startState : mTransitionMap_.keySet() )
        {
            ret.append( "\n\t\t\tstate[" ).append( startState ).append( "]: " );
            for ( String transitionName : mTransitionMap_.get( startState ).keySet() )
            {
                ret.append( "transition[" ).append( transitionName ).append( "] " );
            }
        }

        return ret.toString();
    }
}