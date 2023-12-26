import React, { Component } from 'react'
import PerLengthDCLineParameterService from '../services/PerLengthDCLineParameterService';

class CreatePerLengthDCLineParameterComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            // step 2
            id: this.props.match.params.id,
                capacitance: '',
                inductance: '',
                resistance: ''
        }
        this.changecapacitanceHandler = this.changecapacitanceHandler.bind(this);
        this.changeinductanceHandler = this.changeinductanceHandler.bind(this);
        this.changeresistanceHandler = this.changeresistanceHandler.bind(this);
    }

    // step 3
    componentDidMount(){

        // step 4
        if(this.state.id === '_add'){
            return
        }else{
            PerLengthDCLineParameterService.getPerLengthDCLineParameterById(this.state.id).then( (res) =>{
                let perLengthDCLineParameter = res.data;
                this.setState({
                    capacitance: perLengthDCLineParameter.capacitance,
                    inductance: perLengthDCLineParameter.inductance,
                    resistance: perLengthDCLineParameter.resistance
                });
            });
        }        
    }
    saveOrUpdatePerLengthDCLineParameter = (e) => {
        e.preventDefault();
        let perLengthDCLineParameter = {
                perLengthDCLineParameterId: this.state.id,
                capacitance: this.state.capacitance,
                inductance: this.state.inductance,
                resistance: this.state.resistance
            };
        console.log('perLengthDCLineParameter => ' + JSON.stringify(perLengthDCLineParameter));

        // step 5
        if(this.state.id === '_add'){
            perLengthDCLineParameter.perLengthDCLineParameterId=''
            PerLengthDCLineParameterService.createPerLengthDCLineParameter(perLengthDCLineParameter).then(res =>{
                this.props.history.push('/perLengthDCLineParameters');
            });
        }else{
            PerLengthDCLineParameterService.updatePerLengthDCLineParameter(perLengthDCLineParameter).then( res => {
                this.props.history.push('/perLengthDCLineParameters');
            });
        }
    }
    
    changecapacitanceHandler= (event) => {
        this.setState({capacitance: event.target.value});
    }
    changeinductanceHandler= (event) => {
        this.setState({inductance: event.target.value});
    }
    changeresistanceHandler= (event) => {
        this.setState({resistance: event.target.value});
    }

    cancel(){
        this.props.history.push('/perLengthDCLineParameters');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add PerLengthDCLineParameter</h3>
        }else{
            return <h3 className="text-center">Update PerLengthDCLineParameter</h3>
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
                                            <label> capacitance: </label>
                                            #formFields( $attribute, 'create')
                                            <label> inductance: </label>
                                            #formFields( $attribute, 'create')
                                            <label> resistance: </label>
                                            #formFields( $attribute, 'create')
                                        </div>

                                        <button className="btn btn-success" onClick={this.saveOrUpdatePerLengthDCLineParameter}>Save</button>
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

export default CreatePerLengthDCLineParameterComponent
