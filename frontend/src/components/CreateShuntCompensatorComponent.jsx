import React, { Component } from 'react'
import ShuntCompensatorService from '../services/ShuntCompensatorService';

class CreateShuntCompensatorComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            // step 2
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
        this.changeaVRDelayHandler = this.changeaVRDelayHandler.bind(this);
        this.changegroundedHandler = this.changegroundedHandler.bind(this);
        this.changemaximumSectionsHandler = this.changemaximumSectionsHandler.bind(this);
        this.changenomUHandler = this.changenomUHandler.bind(this);
        this.changenormalSectionsHandler = this.changenormalSectionsHandler.bind(this);
        this.changeswitchOnCountHandler = this.changeswitchOnCountHandler.bind(this);
        this.changeswitchOnDateHandler = this.changeswitchOnDateHandler.bind(this);
        this.changevoltageSensitivityHandler = this.changevoltageSensitivityHandler.bind(this);
    }

    // step 3
    componentDidMount(){

        // step 4
        if(this.state.id === '_add'){
            return
        }else{
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
    }
    saveOrUpdateShuntCompensator = (e) => {
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

        // step 5
        if(this.state.id === '_add'){
            shuntCompensator.shuntCompensatorId=''
            ShuntCompensatorService.createShuntCompensator(shuntCompensator).then(res =>{
                this.props.history.push('/shuntCompensators');
            });
        }else{
            ShuntCompensatorService.updateShuntCompensator(shuntCompensator).then( res => {
                this.props.history.push('/shuntCompensators');
            });
        }
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

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add ShuntCompensator</h3>
        }else{
            return <h3 className="text-center">Update ShuntCompensator</h3>
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
                                            <label> aVRDelay: </label>
                                            #formFields( $attribute, 'create')
                                            <label> grounded: </label>
                                            #formFields( $attribute, 'create')
                                            <label> maximumSections: </label>
                                            #formFields( $attribute, 'create')
                                            <label> nomU: </label>
                                            #formFields( $attribute, 'create')
                                            <label> normalSections: </label>
                                            #formFields( $attribute, 'create')
                                            <label> switchOnCount: </label>
                                            #formFields( $attribute, 'create')
                                            <label> switchOnDate: </label>
                                            #formFields( $attribute, 'create')
                                            <label> voltageSensitivity: </label>
                                            #formFields( $attribute, 'create')
                                        </div>

                                        <button className="btn btn-success" onClick={this.saveOrUpdateShuntCompensator}>Save</button>
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

export default CreateShuntCompensatorComponent
