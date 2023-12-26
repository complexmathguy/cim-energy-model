import React, { Component } from 'react'
import Quality61850Service from '../services/Quality61850Service';

class UpdateQuality61850Component extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
                badReference: '',
                estimatorReplaced: '',
                failure: '',
                oldData: '',
                operatorBlocked: '',
                oscillatory: '',
                outOfRange: '',
                overFlow: '',
                source: '',
                suspect: '',
                test: '',
                validity: ''
        }
        this.updateQuality61850 = this.updateQuality61850.bind(this);

        this.changebadReferenceHandler = this.changebadReferenceHandler.bind(this);
        this.changeestimatorReplacedHandler = this.changeestimatorReplacedHandler.bind(this);
        this.changefailureHandler = this.changefailureHandler.bind(this);
        this.changeoldDataHandler = this.changeoldDataHandler.bind(this);
        this.changeoperatorBlockedHandler = this.changeoperatorBlockedHandler.bind(this);
        this.changeoscillatoryHandler = this.changeoscillatoryHandler.bind(this);
        this.changeoutOfRangeHandler = this.changeoutOfRangeHandler.bind(this);
        this.changeoverFlowHandler = this.changeoverFlowHandler.bind(this);
        this.changesourceHandler = this.changesourceHandler.bind(this);
        this.changesuspectHandler = this.changesuspectHandler.bind(this);
        this.changetestHandler = this.changetestHandler.bind(this);
        this.changevalidityHandler = this.changevalidityHandler.bind(this);
    }

    componentDidMount(){
        Quality61850Service.getQuality61850ById(this.state.id).then( (res) =>{
            let quality61850 = res.data;
            this.setState({
                badReference: quality61850.badReference,
                estimatorReplaced: quality61850.estimatorReplaced,
                failure: quality61850.failure,
                oldData: quality61850.oldData,
                operatorBlocked: quality61850.operatorBlocked,
                oscillatory: quality61850.oscillatory,
                outOfRange: quality61850.outOfRange,
                overFlow: quality61850.overFlow,
                source: quality61850.source,
                suspect: quality61850.suspect,
                test: quality61850.test,
                validity: quality61850.validity
            });
        });
    }

    updateQuality61850 = (e) => {
        e.preventDefault();
        let quality61850 = {
            quality61850Id: this.state.id,
            badReference: this.state.badReference,
            estimatorReplaced: this.state.estimatorReplaced,
            failure: this.state.failure,
            oldData: this.state.oldData,
            operatorBlocked: this.state.operatorBlocked,
            oscillatory: this.state.oscillatory,
            outOfRange: this.state.outOfRange,
            overFlow: this.state.overFlow,
            source: this.state.source,
            suspect: this.state.suspect,
            test: this.state.test,
            validity: this.state.validity
        };
        console.log('quality61850 => ' + JSON.stringify(quality61850));
        console.log('id => ' + JSON.stringify(this.state.id));
        Quality61850Service.updateQuality61850(quality61850).then( res => {
            this.props.history.push('/quality61850s');
        });
    }

    changebadReferenceHandler= (event) => {
        this.setState({badReference: event.target.value});
    }
    changeestimatorReplacedHandler= (event) => {
        this.setState({estimatorReplaced: event.target.value});
    }
    changefailureHandler= (event) => {
        this.setState({failure: event.target.value});
    }
    changeoldDataHandler= (event) => {
        this.setState({oldData: event.target.value});
    }
    changeoperatorBlockedHandler= (event) => {
        this.setState({operatorBlocked: event.target.value});
    }
    changeoscillatoryHandler= (event) => {
        this.setState({oscillatory: event.target.value});
    }
    changeoutOfRangeHandler= (event) => {
        this.setState({outOfRange: event.target.value});
    }
    changeoverFlowHandler= (event) => {
        this.setState({overFlow: event.target.value});
    }
    changesourceHandler= (event) => {
        this.setState({source: event.target.value});
    }
    changesuspectHandler= (event) => {
        this.setState({suspect: event.target.value});
    }
    changetestHandler= (event) => {
        this.setState({test: event.target.value});
    }
    changevalidityHandler= (event) => {
        this.setState({validity: event.target.value});
    }

    cancel(){
        this.props.history.push('/quality61850s');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update Quality61850</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                            <label> badReference: </label>
                                            #formFields( $attribute, 'update')
                                            <label> estimatorReplaced: </label>
                                            #formFields( $attribute, 'update')
                                            <label> failure: </label>
                                            #formFields( $attribute, 'update')
                                            <label> oldData: </label>
                                            #formFields( $attribute, 'update')
                                            <label> operatorBlocked: </label>
                                            #formFields( $attribute, 'update')
                                            <label> oscillatory: </label>
                                            #formFields( $attribute, 'update')
                                            <label> outOfRange: </label>
                                            #formFields( $attribute, 'update')
                                            <label> overFlow: </label>
                                            #formFields( $attribute, 'update')
                                            <label> source: </label>
                                            #formFields( $attribute, 'update')
                                            <label> suspect: </label>
                                            #formFields( $attribute, 'update')
                                            <label> test: </label>
                                            #formFields( $attribute, 'update')
                                            <label> validity: </label>
                                            #formFields( $attribute, 'update')
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateQuality61850}>Save</button>
                                        <button className="btn btn-danger" onClick={this.cancel.bind(this)} style={{marginLeft: "10px"}}>Cancel</button>
                                    </form>
                                </div>
                            </div>
                        </div>

                   </div>
            </div>
        )
    }
}

export default UpdateQuality61850Component
