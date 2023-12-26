import React, { Component } from 'react'
import PerLengthDCLineParameterService from '../services/PerLengthDCLineParameterService';

class UpdatePerLengthDCLineParameterComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
                capacitance: '',
                inductance: '',
                resistance: ''
        }
        this.updatePerLengthDCLineParameter = this.updatePerLengthDCLineParameter.bind(this);

        this.changecapacitanceHandler = this.changecapacitanceHandler.bind(this);
        this.changeinductanceHandler = this.changeinductanceHandler.bind(this);
        this.changeresistanceHandler = this.changeresistanceHandler.bind(this);
    }

    componentDidMount(){
        PerLengthDCLineParameterService.getPerLengthDCLineParameterById(this.state.id).then( (res) =>{
            let perLengthDCLineParameter = res.data;
            this.setState({
                capacitance: perLengthDCLineParameter.capacitance,
                inductance: perLengthDCLineParameter.inductance,
                resistance: perLengthDCLineParameter.resistance
            });
        });
    }

    updatePerLengthDCLineParameter = (e) => {
        e.preventDefault();
        let perLengthDCLineParameter = {
            perLengthDCLineParameterId: this.state.id,
            capacitance: this.state.capacitance,
            inductance: this.state.inductance,
            resistance: this.state.resistance
        };
        console.log('perLengthDCLineParameter => ' + JSON.stringify(perLengthDCLineParameter));
        console.log('id => ' + JSON.stringify(this.state.id));
        PerLengthDCLineParameterService.updatePerLengthDCLineParameter(perLengthDCLineParameter).then( res => {
            this.props.history.push('/perLengthDCLineParameters');
        });
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

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update PerLengthDCLineParameter</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                            <label> capacitance: </label>
                                            #formFields( $attribute, 'update')
                                            <label> inductance: </label>
                                            #formFields( $attribute, 'update')
                                            <label> resistance: </label>
                                            #formFields( $attribute, 'update')
                                        </div>
                                        <button className="btn btn-success" onClick={this.updatePerLengthDCLineParameter}>Save</button>
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

export default UpdatePerLengthDCLineParameterComponent
