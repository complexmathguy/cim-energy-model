import React, { Component } from 'react'
import ShuntCompensatorService from '../services/ShuntCompensatorService';

class UpdateShuntCompensatorComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
                aVRDelay: '',
                grounded: '',
                maximumSections: '',
                nomU: '',
                normalSections: '',
                switchOnCount: '',
                switchOnDate: '',
                voltageSensitivity: ''
        }
        this.updateShuntCompensator = this.updateShuntCompensator.bind(this);

        this.changeaVRDelayHandler = this.changeaVRDelayHandler.bind(this);
        this.changegroundedHandler = this.changegroundedHandler.bind(this);
        this.changemaximumSectionsHandler = this.changemaximumSectionsHandler.bind(this);
        this.changenomUHandler = this.changenomUHandler.bind(this);
        this.changenormalSectionsHandler = this.changenormalSectionsHandler.bind(this);
        this.changeswitchOnCountHandler = this.changeswitchOnCountHandler.bind(this);
        this.changeswitchOnDateHandler = this.changeswitchOnDateHandler.bind(this);
        this.changevoltageSensitivityHandler = this.changevoltageSensitivityHandler.bind(this);
    }

    componentDidMount(){
        ShuntCompensatorService.getShuntCompensatorById(this.state.id).then( (res) =>{
            let shuntCompensator = res.data;
            this.setState({
                aVRDelay: shuntCompensator.aVRDelay,
                grounded: shuntCompensator.grounded,
                maximumSections: shuntCompensator.maximumSections,
                nomU: shuntCompensator.nomU,
                normalSections: shuntCompensator.normalSections,
                switchOnCount: shuntCompensator.switchOnCount,
                switchOnDate: shuntCompensator.switchOnDate,
                voltageSensitivity: shuntCompensator.voltageSensitivity
            });
        });
    }

    updateShuntCompensator = (e) => {
        e.preventDefault();
        let shuntCompensator = {
            shuntCompensatorId: this.state.id,
            aVRDelay: this.state.aVRDelay,
            grounded: this.state.grounded,
            maximumSections: this.state.maximumSections,
            nomU: this.state.nomU,
            normalSections: this.state.normalSections,
            switchOnCount: this.state.switchOnCount,
            switchOnDate: this.state.switchOnDate,
            voltageSensitivity: this.state.voltageSensitivity
        };
        console.log('shuntCompensator => ' + JSON.stringify(shuntCompensator));
        console.log('id => ' + JSON.stringify(this.state.id));
        ShuntCompensatorService.updateShuntCompensator(shuntCompensator).then( res => {
            this.props.history.push('/shuntCompensators');
        });
    }

    changeaVRDelayHandler= (event) => {
        this.setState({aVRDelay: event.target.value});
    }
    changegroundedHandler= (event) => {
        this.setState({grounded: event.target.value});
    }
    changemaximumSectionsHandler= (event) => {
        this.setState({maximumSections: event.target.value});
    }
    changenomUHandler= (event) => {
        this.setState({nomU: event.target.value});
    }
    changenormalSectionsHandler= (event) => {
        this.setState({normalSections: event.target.value});
    }
    changeswitchOnCountHandler= (event) => {
        this.setState({switchOnCount: event.target.value});
    }
    changeswitchOnDateHandler= (event) => {
        this.setState({switchOnDate: event.target.value});
    }
    changevoltageSensitivityHandler= (event) => {
        this.setState({voltageSensitivity: event.target.value});
    }

    cancel(){
        this.props.history.push('/shuntCompensators');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update ShuntCompensator</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                            <label> aVRDelay: </label>
                                            #formFields( $attribute, 'update')
                                            <label> grounded: </label>
                                            #formFields( $attribute, 'update')
                                            <label> maximumSections: </label>
                                            #formFields( $attribute, 'update')
                                            <label> nomU: </label>
                                            #formFields( $attribute, 'update')
                                            <label> normalSections: </label>
                                            #formFields( $attribute, 'update')
                                            <label> switchOnCount: </label>
                                            #formFields( $attribute, 'update')
                                            <label> switchOnDate: </label>
                                            #formFields( $attribute, 'update')
                                            <label> voltageSensitivity: </label>
                                            #formFields( $attribute, 'update')
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateShuntCompensator}>Save</button>
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

export default UpdateShuntCompensatorComponent
