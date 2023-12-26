import React, { Component } from 'react'
import VoltageCompensatorUserDefinedService from '../services/VoltageCompensatorUserDefinedService';

class UpdateVoltageCompensatorUserDefinedComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
                proprietary: ''
        }
        this.updateVoltageCompensatorUserDefined = this.updateVoltageCompensatorUserDefined.bind(this);

        this.changeproprietaryHandler = this.changeproprietaryHandler.bind(this);
    }

    componentDidMount(){
        VoltageCompensatorUserDefinedService.getVoltageCompensatorUserDefinedById(this.state.id).then( (res) =>{
            let voltageCompensatorUserDefined = res.data;
            this.setState({
                proprietary: voltageCompensatorUserDefined.proprietary
            });
        });
    }

    updateVoltageCompensatorUserDefined = (e) => {
        e.preventDefault();
        let voltageCompensatorUserDefined = {
            voltageCompensatorUserDefinedId: this.state.id,
            proprietary: this.state.proprietary
        };
        console.log('voltageCompensatorUserDefined => ' + JSON.stringify(voltageCompensatorUserDefined));
        console.log('id => ' + JSON.stringify(this.state.id));
        VoltageCompensatorUserDefinedService.updateVoltageCompensatorUserDefined(voltageCompensatorUserDefined).then( res => {
            this.props.history.push('/voltageCompensatorUserDefineds');
        });
    }

    changeproprietaryHandler= (event) => {
        this.setState({proprietary: event.target.value});
    }

    cancel(){
        this.props.history.push('/voltageCompensatorUserDefineds');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update VoltageCompensatorUserDefined</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                            <label> proprietary: </label>
                                            #formFields( $attribute, 'update')
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateVoltageCompensatorUserDefined}>Save</button>
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

export default UpdateVoltageCompensatorUserDefinedComponent
