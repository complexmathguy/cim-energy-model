import React, { Component } from 'react'
import RatioTapChangerService from '../services/RatioTapChangerService';

class CreateRatioTapChangerComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            // step 2
            id: this.props.match.params.id,
                stepVoltageIncrement: '',
                tculControlMode: ''
        }
        this.changestepVoltageIncrementHandler = this.changestepVoltageIncrementHandler.bind(this);
        this.changetculControlModeHandler = this.changetculControlModeHandler.bind(this);
    }

    // step 3
    componentDidMount(){

        // step 4
        if(this.state.id === '_add'){
            return
        }else{
            RatioTapChangerService.getRatioTapChangerById(this.state.id).then( (res) =>{
                let ratioTapChanger = res.data;
                this.setState({
                    stepVoltageIncrement: ratioTapChanger.stepVoltageIncrement,
                    tculControlMode: ratioTapChanger.tculControlMode
                });
            });
        }        
    }
    saveOrUpdateRatioTapChanger = (e) => {
        e.preventDefault();
        let ratioTapChanger = {
                ratioTapChangerId: this.state.id,
                stepVoltageIncrement: this.state.stepVoltageIncrement,
                tculControlMode: this.state.tculControlMode
            };
        console.log('ratioTapChanger => ' + JSON.stringify(ratioTapChanger));

        // step 5
        if(this.state.id === '_add'){
            ratioTapChanger.ratioTapChangerId=''
            RatioTapChangerService.createRatioTapChanger(ratioTapChanger).then(res =>{
                this.props.history.push('/ratioTapChangers');
            });
        }else{
            RatioTapChangerService.updateRatioTapChanger(ratioTapChanger).then( res => {
                this.props.history.push('/ratioTapChangers');
            });
        }
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

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add RatioTapChanger</h3>
        }else{
            return <h3 className="text-center">Update RatioTapChanger</h3>
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
                                            <label> stepVoltageIncrement: </label>
                                            #formFields( $attribute, 'create')
                                            <label> tculControlMode: </label>
                                            #formFields( $attribute, 'create')
                                        </div>

                                        <button className="btn btn-success" onClick={this.saveOrUpdateRatioTapChanger}>Save</button>
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

export default CreateRatioTapChangerComponent
