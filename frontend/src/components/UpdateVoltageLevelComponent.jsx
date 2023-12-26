import React, { Component } from 'react'
import VoltageLevelService from '../services/VoltageLevelService';

class UpdateVoltageLevelComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
                highVoltageLimit: '',
                lowVoltageLimit: ''
        }
        this.updateVoltageLevel = this.updateVoltageLevel.bind(this);

        this.changehighVoltageLimitHandler = this.changehighVoltageLimitHandler.bind(this);
        this.changelowVoltageLimitHandler = this.changelowVoltageLimitHandler.bind(this);
    }

    componentDidMount(){
        VoltageLevelService.getVoltageLevelById(this.state.id).then( (res) =>{
            let voltageLevel = res.data;
            this.setState({
                highVoltageLimit: voltageLevel.highVoltageLimit,
                lowVoltageLimit: voltageLevel.lowVoltageLimit
            });
        });
    }

    updateVoltageLevel = (e) => {
        e.preventDefault();
        let voltageLevel = {
            voltageLevelId: this.state.id,
            highVoltageLimit: this.state.highVoltageLimit,
            lowVoltageLimit: this.state.lowVoltageLimit
        };
        console.log('voltageLevel => ' + JSON.stringify(voltageLevel));
        console.log('id => ' + JSON.stringify(this.state.id));
        VoltageLevelService.updateVoltageLevel(voltageLevel).then( res => {
            this.props.history.push('/voltageLevels');
        });
    }

    changehighVoltageLimitHandler= (event) => {
        this.setState({highVoltageLimit: event.target.value});
    }
    changelowVoltageLimitHandler= (event) => {
        this.setState({lowVoltageLimit: event.target.value});
    }

    cancel(){
        this.props.history.push('/voltageLevels');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update VoltageLevel</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                            <label> highVoltageLimit: </label>
                                            #formFields( $attribute, 'update')
                                            <label> lowVoltageLimit: </label>
                                            #formFields( $attribute, 'update')
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateVoltageLevel}>Save</button>
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

export default UpdateVoltageLevelComponent
