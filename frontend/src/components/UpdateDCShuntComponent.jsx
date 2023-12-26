import React, { Component } from 'react'
import DCShuntService from '../services/DCShuntService';

class UpdateDCShuntComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
                capacitance: '',
                ratedUdc: '',
                resistance: ''
        }
        this.updateDCShunt = this.updateDCShunt.bind(this);

        this.changecapacitanceHandler = this.changecapacitanceHandler.bind(this);
        this.changeratedUdcHandler = this.changeratedUdcHandler.bind(this);
        this.changeresistanceHandler = this.changeresistanceHandler.bind(this);
    }

    componentDidMount(){
        DCShuntService.getDCShuntById(this.state.id).then( (res) =>{
            let dCShunt = res.data;
            this.setState({
                capacitance: dCShunt.capacitance,
                ratedUdc: dCShunt.ratedUdc,
                resistance: dCShunt.resistance
            });
        });
    }

    updateDCShunt = (e) => {
        e.preventDefault();
        let dCShunt = {
            dCShuntId: this.state.id,
            capacitance: this.state.capacitance,
            ratedUdc: this.state.ratedUdc,
            resistance: this.state.resistance
        };
        console.log('dCShunt => ' + JSON.stringify(dCShunt));
        console.log('id => ' + JSON.stringify(this.state.id));
        DCShuntService.updateDCShunt(dCShunt).then( res => {
            this.props.history.push('/dCShunts');
        });
    }

    changecapacitanceHandler= (event) => {
        this.setState({capacitance: event.target.value});
    }
    changeratedUdcHandler= (event) => {
        this.setState({ratedUdc: event.target.value});
    }
    changeresistanceHandler= (event) => {
        this.setState({resistance: event.target.value});
    }

    cancel(){
        this.props.history.push('/dCShunts');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update DCShunt</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                            <label> capacitance: </label>
                                            #formFields( $attribute, 'update')
                                            <label> ratedUdc: </label>
                                            #formFields( $attribute, 'update')
                                            <label> resistance: </label>
                                            #formFields( $attribute, 'update')
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateDCShunt}>Save</button>
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

export default UpdateDCShuntComponent
