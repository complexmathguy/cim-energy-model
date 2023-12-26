import React, { Component } from 'react'
import ApparentPowerLimitService from '../services/ApparentPowerLimitService';

class UpdateApparentPowerLimitComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
                value: ''
        }
        this.updateApparentPowerLimit = this.updateApparentPowerLimit.bind(this);

        this.changevalueHandler = this.changevalueHandler.bind(this);
    }

    componentDidMount(){
        ApparentPowerLimitService.getApparentPowerLimitById(this.state.id).then( (res) =>{
            let apparentPowerLimit = res.data;
            this.setState({
                value: apparentPowerLimit.value
            });
        });
    }

    updateApparentPowerLimit = (e) => {
        e.preventDefault();
        let apparentPowerLimit = {
            apparentPowerLimitId: this.state.id,
            value: this.state.value
        };
        console.log('apparentPowerLimit => ' + JSON.stringify(apparentPowerLimit));
        console.log('id => ' + JSON.stringify(this.state.id));
        ApparentPowerLimitService.updateApparentPowerLimit(apparentPowerLimit).then( res => {
            this.props.history.push('/apparentPowerLimits');
        });
    }

    changevalueHandler= (event) => {
        this.setState({value: event.target.value});
    }

    cancel(){
        this.props.history.push('/apparentPowerLimits');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update ApparentPowerLimit</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                            <label> value: </label>
                                            #formFields( $attribute, 'update')
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateApparentPowerLimit}>Save</button>
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

export default UpdateApparentPowerLimitComponent
