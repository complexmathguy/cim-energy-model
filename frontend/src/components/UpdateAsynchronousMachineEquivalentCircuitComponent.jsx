import React, { Component } from 'react'
import AsynchronousMachineEquivalentCircuitService from '../services/AsynchronousMachineEquivalentCircuitService';

class UpdateAsynchronousMachineEquivalentCircuitComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
                rr1: '',
                rr2: '',
                xlr1: '',
                xlr2: '',
                xm: ''
        }
        this.updateAsynchronousMachineEquivalentCircuit = this.updateAsynchronousMachineEquivalentCircuit.bind(this);

        this.changerr1Handler = this.changerr1Handler.bind(this);
        this.changerr2Handler = this.changerr2Handler.bind(this);
        this.changexlr1Handler = this.changexlr1Handler.bind(this);
        this.changexlr2Handler = this.changexlr2Handler.bind(this);
        this.changexmHandler = this.changexmHandler.bind(this);
    }

    componentDidMount(){
        AsynchronousMachineEquivalentCircuitService.getAsynchronousMachineEquivalentCircuitById(this.state.id).then( (res) =>{
            let asynchronousMachineEquivalentCircuit = res.data;
            this.setState({
                rr1: asynchronousMachineEquivalentCircuit.rr1,
                rr2: asynchronousMachineEquivalentCircuit.rr2,
                xlr1: asynchronousMachineEquivalentCircuit.xlr1,
                xlr2: asynchronousMachineEquivalentCircuit.xlr2,
                xm: asynchronousMachineEquivalentCircuit.xm
            });
        });
    }

    updateAsynchronousMachineEquivalentCircuit = (e) => {
        e.preventDefault();
        let asynchronousMachineEquivalentCircuit = {
            asynchronousMachineEquivalentCircuitId: this.state.id,
            rr1: this.state.rr1,
            rr2: this.state.rr2,
            xlr1: this.state.xlr1,
            xlr2: this.state.xlr2,
            xm: this.state.xm
        };
        console.log('asynchronousMachineEquivalentCircuit => ' + JSON.stringify(asynchronousMachineEquivalentCircuit));
        console.log('id => ' + JSON.stringify(this.state.id));
        AsynchronousMachineEquivalentCircuitService.updateAsynchronousMachineEquivalentCircuit(asynchronousMachineEquivalentCircuit).then( res => {
            this.props.history.push('/asynchronousMachineEquivalentCircuits');
        });
    }

    changerr1Handler= (event) => {
        this.setState({rr1: event.target.value});
    }
    changerr2Handler= (event) => {
        this.setState({rr2: event.target.value});
    }
    changexlr1Handler= (event) => {
        this.setState({xlr1: event.target.value});
    }
    changexlr2Handler= (event) => {
        this.setState({xlr2: event.target.value});
    }
    changexmHandler= (event) => {
        this.setState({xm: event.target.value});
    }

    cancel(){
        this.props.history.push('/asynchronousMachineEquivalentCircuits');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update AsynchronousMachineEquivalentCircuit</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                            <label> rr1: </label>
                                            #formFields( $attribute, 'update')
                                            <label> rr2: </label>
                                            #formFields( $attribute, 'update')
                                            <label> xlr1: </label>
                                            #formFields( $attribute, 'update')
                                            <label> xlr2: </label>
                                            #formFields( $attribute, 'update')
                                            <label> xm: </label>
                                            #formFields( $attribute, 'update')
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateAsynchronousMachineEquivalentCircuit}>Save</button>
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

export default UpdateAsynchronousMachineEquivalentCircuitComponent
