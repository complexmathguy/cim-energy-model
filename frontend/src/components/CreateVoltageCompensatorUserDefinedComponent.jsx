import React, { Component } from 'react'
import VoltageCompensatorUserDefinedService from '../services/VoltageCompensatorUserDefinedService';

class CreateVoltageCompensatorUserDefinedComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            // step 2
            id: this.props.match.params.id,
                proprietary: ''
        }
        this.changeproprietaryHandler = this.changeproprietaryHandler.bind(this);
    }

    // step 3
    componentDidMount(){

        // step 4
        if(this.state.id === '_add'){
            return
        }else{
            VoltageCompensatorUserDefinedService.getVoltageCompensatorUserDefinedById(this.state.id).then( (res) =>{
                let voltageCompensatorUserDefined = res.data;
                this.setState({
                    proprietary: voltageCompensatorUserDefined.proprietary
                });
            });
        }        
    }
    saveOrUpdateVoltageCompensatorUserDefined = (e) => {
        e.preventDefault();
        let voltageCompensatorUserDefined = {
                voltageCompensatorUserDefinedId: this.state.id,
                proprietary: this.state.proprietary
            };
        console.log('voltageCompensatorUserDefined => ' + JSON.stringify(voltageCompensatorUserDefined));

        // step 5
        if(this.state.id === '_add'){
            voltageCompensatorUserDefined.voltageCompensatorUserDefinedId=''
            VoltageCompensatorUserDefinedService.createVoltageCompensatorUserDefined(voltageCompensatorUserDefined).then(res =>{
                this.props.history.push('/voltageCompensatorUserDefineds');
            });
        }else{
            VoltageCompensatorUserDefinedService.updateVoltageCompensatorUserDefined(voltageCompensatorUserDefined).then( res => {
                this.props.history.push('/voltageCompensatorUserDefineds');
            });
        }
    }
    
    changeproprietaryHandler= (event) => {
        this.setState({proprietary: event.target.value});
    }

    cancel(){
        this.props.history.push('/voltageCompensatorUserDefineds');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add VoltageCompensatorUserDefined</h3>
        }else{
            return <h3 className="text-center">Update VoltageCompensatorUserDefined</h3>
        }
    }
    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                {
                                    this.getTitle()
                                }
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                            <label> proprietary: </label>
                                            #formFields( $attribute, 'create')
                                        </div>

                                        <button className="btn btn-success" onClick={this.saveOrUpdateVoltageCompensatorUserDefined}>Save</button>
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

export default CreateVoltageCompensatorUserDefinedComponent
