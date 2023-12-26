import React, { Component } from 'react'
import SwitchProxyService from '../services/SwitchProxyService';

class UpdateSwitchProxyComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
                normalOpen: '',
                ratedCurrent: '',
                retained: ''
        }
        this.updateSwitchProxy = this.updateSwitchProxy.bind(this);

        this.changenormalOpenHandler = this.changenormalOpenHandler.bind(this);
        this.changeratedCurrentHandler = this.changeratedCurrentHandler.bind(this);
        this.changeretainedHandler = this.changeretainedHandler.bind(this);
    }

    componentDidMount(){
        SwitchProxyService.getSwitchProxyById(this.state.id).then( (res) =>{
            let switchProxy = res.data;
            this.setState({
                normalOpen: switchProxy.normalOpen,
                ratedCurrent: switchProxy.ratedCurrent,
                retained: switchProxy.retained
            });
        });
    }

    updateSwitchProxy = (e) => {
        e.preventDefault();
        let switchProxy = {
            switchProxyId: this.state.id,
            normalOpen: this.state.normalOpen,
            ratedCurrent: this.state.ratedCurrent,
            retained: this.state.retained
        };
        console.log('switchProxy => ' + JSON.stringify(switchProxy));
        console.log('id => ' + JSON.stringify(this.state.id));
        SwitchProxyService.updateSwitchProxy(switchProxy).then( res => {
            this.props.history.push('/switchProxys');
        });
    }

    changenormalOpenHandler= (event) => {
        this.setState({normalOpen: event.target.value});
    }
    changeratedCurrentHandler= (event) => {
        this.setState({ratedCurrent: event.target.value});
    }
    changeretainedHandler= (event) => {
        this.setState({retained: event.target.value});
    }

    cancel(){
        this.props.history.push('/switchProxys');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update SwitchProxy</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                            <label> normalOpen: </label>
                                            #formFields( $attribute, 'update')
                                            <label> ratedCurrent: </label>
                                            #formFields( $attribute, 'update')
                                            <label> retained: </label>
                                            #formFields( $attribute, 'update')
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateSwitchProxy}>Save</button>
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

export default UpdateSwitchProxyComponent
