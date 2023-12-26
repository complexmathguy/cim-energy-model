import React, { Component } from 'react'
import VoltageLimitService from '../services/VoltageLimitService';

class CreateVoltageLimitComponent extends Component {
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
            VoltageLimitService.getVoltageLimitById(this.state.id).then( (res) =>{
                let voltageLimit = res.data;
                this.setState({
                    value: voltageLimit.value
                });
            });
        }        
    }
    saveOrUpdateVoltageLimit = (e) => {
        e.preventDefault();
        let voltageLimit = {
                voltageLimitId: this.state.id,
                value: this.state.value
            };
        console.log('voltageLimit => ' + JSON.stringify(voltageLimit));

        // step 5
        if(this.state.id === '_add'){
            voltageLimit.voltageLimitId=''
            VoltageLimitService.createVoltageLimit(voltageLimit).then(res =>{
                this.props.history.push('/voltageLimits');
            });
        }else{
            VoltageLimitService.updateVoltageLimit(voltageLimit).then( res => {
                this.props.history.push('/voltageLimits');
            });
        }
    }
    
    changevalueHandler= (event) => {
        this.setState({value: event.target.value});
    }

    cancel(){
        this.props.history.push('/voltageLimits');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add VoltageLimit</h3>
        }else{
            return <h3 className="text-center">Update VoltageLimit</h3>
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

                                        <button className="btn btn-success" onClick={this.saveOrUpdateVoltageLimit}>Save</button>
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

export default CreateVoltageLimitComponent
