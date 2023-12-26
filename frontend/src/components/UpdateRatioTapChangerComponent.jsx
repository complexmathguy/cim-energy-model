import React, { Component } from 'react'
import RatioTapChangerService from '../services/RatioTapChangerService';

class UpdateRatioTapChangerComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
                stepVoltageIncrement: '',
                tculControlMode: ''
        }
        this.updateRatioTapChanger = this.updateRatioTapChanger.bind(this);

        this.changestepVoltageIncrementHandler = this.changestepVoltageIncrementHandler.bind(this);
        this.changetculControlModeHandler = this.changetculControlModeHandler.bind(this);
    }

    componentDidMount(){
        RatioTapChangerService.getRatioTapChangerById(this.state.id).then( (res) =>{
            let ratioTapChanger = res.data;
            this.setState({
                stepVoltageIncrement: ratioTapChanger.stepVoltageIncrement,
                tculControlMode: ratioTapChanger.tculControlMode
            });
        });
    }

    updateRatioTapChanger = (e) => {
        e.preventDefault();
        let ratioTapChanger = {
            ratioTapChangerId: this.state.id,
            stepVoltageIncrement: this.state.stepVoltageIncrement,
            tculControlMode: this.state.tculControlMode
        };
        console.log('ratioTapChanger => ' + JSON.stringify(ratioTapChanger));
        console.log('id => ' + JSON.stringify(this.state.id));
        RatioTapChangerService.updateRatioTapChanger(ratioTapChanger).then( res => {
            this.props.history.push('/ratioTapChangers');
        });
    }

    changestepVoltageIncrementHandler= (event) => {
        this.setState({stepVoltageIncrement: event.target.value});
    }
    changetculControlModeHandler= (event) => {
        this.setState({tculControlMode: event.target.value});
    }

    cancel(){
        this.props.history.push('/ratioTapChangers');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update RatioTapChanger</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                            <label> stepVoltageIncrement: </label>
                                            #formFields( $attribute, 'update')
                                            <label> tculControlMode: </label>
                                            #formFields( $attribute, 'update')
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateRatioTapChanger}>Save</button>
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

export default UpdateRatioTapChangerComponent
