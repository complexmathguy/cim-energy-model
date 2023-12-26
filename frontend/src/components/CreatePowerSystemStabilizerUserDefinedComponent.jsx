import React, { Component } from 'react'
import PowerSystemStabilizerUserDefinedService from '../services/PowerSystemStabilizerUserDefinedService';

class CreatePowerSystemStabilizerUserDefinedComponent extends Component {
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
            PowerSystemStabilizerUserDefinedService.getPowerSystemStabilizerUserDefinedById(this.state.id).then( (res) =>{
                let powerSystemStabilizerUserDefined = res.data;
                this.setState({
                    proprietary: powerSystemStabilizerUserDefined.proprietary
                });
            });
        }        
    }
    saveOrUpdatePowerSystemStabilizerUserDefined = (e) => {
        e.preventDefault();
        let powerSystemStabilizerUserDefined = {
                powerSystemStabilizerUserDefinedId: this.state.id,
                proprietary: this.state.proprietary
            };
        console.log('powerSystemStabilizerUserDefined => ' + JSON.stringify(powerSystemStabilizerUserDefined));

        // step 5
        if(this.state.id === '_add'){
            powerSystemStabilizerUserDefined.powerSystemStabilizerUserDefinedId=''
            PowerSystemStabilizerUserDefinedService.createPowerSystemStabilizerUserDefined(powerSystemStabilizerUserDefined).then(res =>{
                this.props.history.push('/powerSystemStabilizerUserDefineds');
            });
        }else{
            PowerSystemStabilizerUserDefinedService.updatePowerSystemStabilizerUserDefined(powerSystemStabilizerUserDefined).then( res => {
                this.props.history.push('/powerSystemStabilizerUserDefineds');
            });
        }
    }
    
    changeproprietaryHandler= (event) => {
        this.setState({proprietary: event.target.value});
    }

    cancel(){
        this.props.history.push('/powerSystemStabilizerUserDefineds');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add PowerSystemStabilizerUserDefined</h3>
        }else{
            return <h3 className="text-center">Update PowerSystemStabilizerUserDefined</h3>
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

                                        <button className="btn btn-success" onClick={this.saveOrUpdatePowerSystemStabilizerUserDefined}>Save</button>
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

export default CreatePowerSystemStabilizerUserDefinedComponent
