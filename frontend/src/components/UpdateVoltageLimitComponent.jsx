import React, { Component } from 'react'
import VoltageLimitService from '../services/VoltageLimitService';

class UpdateVoltageLimitComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
                value: ''
        }
        this.updateVoltageLimit = this.updateVoltageLimit.bind(this);

        this.changevalueHandler = this.changevalueHandler.bind(this);
    }

    componentDidMount(){
        VoltageLimitService.getVoltageLimitById(this.state.id).then( (res) =>{
            let voltageLimit = res.data;
            this.setState({
                value: voltageLimit.value
            });
        });
    }

    updateVoltageLimit = (e) => {
        e.preventDefault();
        let voltageLimit = {
            voltageLimitId: this.state.id,
            value: this.state.value
        };
        console.log('voltageLimit => ' + JSON.stringify(voltageLimit));
        console.log('id => ' + JSON.stringify(this.state.id));
        VoltageLimitService.updateVoltageLimit(voltageLimit).then( res => {
            this.props.history.push('/voltageLimits');
        });
    }

    changevalueHandler= (event) => {
        this.setState({value: event.target.value});
    }

    cancel(){
        this.props.history.push('/voltageLimits');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update VoltageLimit</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                            <label> value: </label>
                                            #formFields( $attribute, 'update')
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateVoltageLimit}>Save</button>
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

export default UpdateVoltageLimitComponent
