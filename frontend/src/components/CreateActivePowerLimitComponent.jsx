import React, { Component } from 'react'
import ActivePowerLimitService from '../services/ActivePowerLimitService';

class CreateActivePowerLimitComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            // step 2
            id: this.props.match.params.id,
                value: ''
        }
        this.changevalueHandler = this.changevalueHandler.bind(this);
    }

    // step 3
    componentDidMount(){

        // step 4
        if(this.state.id === '_add'){
            return
        }else{
            ActivePowerLimitService.getActivePowerLimitById(this.state.id).then( (res) =>{
                let activePowerLimit = res.data;
                this.setState({
                    value: activePowerLimit.value
                });
            });
        }        
    }
    saveOrUpdateActivePowerLimit = (e) => {
        e.preventDefault();
        let activePowerLimit = {
                activePowerLimitId: this.state.id,
                value: this.state.value
            };
        console.log('activePowerLimit => ' + JSON.stringify(activePowerLimit));

        // step 5
        if(this.state.id === '_add'){
            activePowerLimit.activePowerLimitId=''
            ActivePowerLimitService.createActivePowerLimit(activePowerLimit).then(res =>{
                this.props.history.push('/activePowerLimits');
            });
        }else{
            ActivePowerLimitService.updateActivePowerLimit(activePowerLimit).then( res => {
                this.props.history.push('/activePowerLimits');
            });
        }
    }
    
    changevalueHandler= (event) => {
        this.setState({value: event.target.value});
    }

    cancel(){
        this.props.history.push('/activePowerLimits');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add ActivePowerLimit</h3>
        }else{
            return <h3 className="text-center">Update ActivePowerLimit</h3>
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
                                            <label> value: </label>
                                            #formFields( $attribute, 'create')
                                        </div>

                                        <button className="btn btn-success" onClick={this.saveOrUpdateActivePowerLimit}>Save</button>
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

export default CreateActivePowerLimitComponent
