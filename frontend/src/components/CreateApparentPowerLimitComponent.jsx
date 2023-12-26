import React, { Component } from 'react'
import ApparentPowerLimitService from '../services/ApparentPowerLimitService';

class CreateApparentPowerLimitComponent extends Component {
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
            ApparentPowerLimitService.getApparentPowerLimitById(this.state.id).then( (res) =>{
                let apparentPowerLimit = res.data;
                this.setState({
                    value: apparentPowerLimit.value
                });
            });
        }        
    }
    saveOrUpdateApparentPowerLimit = (e) => {
        e.preventDefault();
        let apparentPowerLimit = {
                apparentPowerLimitId: this.state.id,
                value: this.state.value
            };
        console.log('apparentPowerLimit => ' + JSON.stringify(apparentPowerLimit));

        // step 5
        if(this.state.id === '_add'){
            apparentPowerLimit.apparentPowerLimitId=''
            ApparentPowerLimitService.createApparentPowerLimit(apparentPowerLimit).then(res =>{
                this.props.history.push('/apparentPowerLimits');
            });
        }else{
            ApparentPowerLimitService.updateApparentPowerLimit(apparentPowerLimit).then( res => {
                this.props.history.push('/apparentPowerLimits');
            });
        }
    }
    
    changevalueHandler= (event) => {
        this.setState({value: event.target.value});
    }

    cancel(){
        this.props.history.push('/apparentPowerLimits');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add ApparentPowerLimit</h3>
        }else{
            return <h3 className="text-center">Update ApparentPowerLimit</h3>
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

                                        <button className="btn btn-success" onClick={this.saveOrUpdateApparentPowerLimit}>Save</button>
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

export default CreateApparentPowerLimitComponent
