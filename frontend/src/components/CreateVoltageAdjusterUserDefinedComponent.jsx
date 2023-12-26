import React, { Component } from 'react'
import VoltageAdjusterUserDefinedService from '../services/VoltageAdjusterUserDefinedService';

class CreateVoltageAdjusterUserDefinedComponent extends Component {
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
            VoltageAdjusterUserDefinedService.getVoltageAdjusterUserDefinedById(this.state.id).then( (res) =>{
                let voltageAdjusterUserDefined = res.data;
                this.setState({
                    proprietary: voltageAdjusterUserDefined.proprietary
                });
            });
        }        
    }
    saveOrUpdateVoltageAdjusterUserDefined = (e) => {
        e.preventDefault();
        let voltageAdjusterUserDefined = {
                voltageAdjusterUserDefinedId: this.state.id,
                proprietary: this.state.proprietary
            };
        console.log('voltageAdjusterUserDefined => ' + JSON.stringify(voltageAdjusterUserDefined));

        // step 5
        if(this.state.id === '_add'){
            voltageAdjusterUserDefined.voltageAdjusterUserDefinedId=''
            VoltageAdjusterUserDefinedService.createVoltageAdjusterUserDefined(voltageAdjusterUserDefined).then(res =>{
                this.props.history.push('/voltageAdjusterUserDefineds');
            });
        }else{
            VoltageAdjusterUserDefinedService.updateVoltageAdjusterUserDefined(voltageAdjusterUserDefined).then( res => {
                this.props.history.push('/voltageAdjusterUserDefineds');
            });
        }
    }
    
    changeproprietaryHandler= (event) => {
        this.setState({proprietary: event.target.value});
    }

    cancel(){
        this.props.history.push('/voltageAdjusterUserDefineds');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add VoltageAdjusterUserDefined</h3>
        }else{
            return <h3 className="text-center">Update VoltageAdjusterUserDefined</h3>
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

                                        <button className="btn btn-success" onClick={this.saveOrUpdateVoltageAdjusterUserDefined}>Save</button>
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

export default CreateVoltageAdjusterUserDefinedComponent
