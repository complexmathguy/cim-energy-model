import React, { Component } from 'react'
import ConductanceService from '../services/ConductanceService';

class UpdateConductanceComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
                multiplier: '',
                unit: '',
                value: ''
        }
        this.updateConductance = this.updateConductance.bind(this);

        this.changemultiplierHandler = this.changemultiplierHandler.bind(this);
        this.changeunitHandler = this.changeunitHandler.bind(this);
        this.changevalueHandler = this.changevalueHandler.bind(this);
    }

    componentDidMount(){
        ConductanceService.getConductanceById(this.state.id).then( (res) =>{
            let conductance = res.data;
            this.setState({
                multiplier: conductance.multiplier,
                unit: conductance.unit,
                value: conductance.value
            });
        });
    }

    updateConductance = (e) => {
        e.preventDefault();
        let conductance = {
            conductanceId: this.state.id,
            multiplier: this.state.multiplier,
            unit: this.state.unit,
            value: this.state.value
        };
        console.log('conductance => ' + JSON.stringify(conductance));
        console.log('id => ' + JSON.stringify(this.state.id));
        ConductanceService.updateConductance(conductance).then( res => {
            this.props.history.push('/conductances');
        });
    }

    changemultiplierHandler= (event) => {
        this.setState({multiplier: event.target.value});
    }
    changeunitHandler= (event) => {
        this.setState({unit: event.target.value});
    }
    changevalueHandler= (event) => {
        this.setState({value: event.target.value});
    }

    cancel(){
        this.props.history.push('/conductances');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update Conductance</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                            <label> multiplier: </label>
                                            #formFields( $attribute, 'update')
                                            <label> unit: </label>
                                            #formFields( $attribute, 'update')
                                            <label> value: </label>
                                            #formFields( $attribute, 'update')
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateConductance}>Save</button>
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

export default UpdateConductanceComponent
