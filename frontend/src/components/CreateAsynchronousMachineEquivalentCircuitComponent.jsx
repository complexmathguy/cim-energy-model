import React, { Component } from 'react'
import AsynchronousMachineEquivalentCircuitService from '../services/AsynchronousMachineEquivalentCircuitService';

class CreateAsynchronousMachineEquivalentCircuitComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            // step 2
            id: this.props.match.params.id,
                rr1: '',
                rr2: '',
                xlr1: '',
                xlr2: '',
                xm: ''
        }
        this.changerr1Handler = this.changerr1Handler.bind(this);
        this.changerr2Handler = this.changerr2Handler.bind(this);
        this.changexlr1Handler = this.changexlr1Handler.bind(this);
        this.changexlr2Handler = this.changexlr2Handler.bind(this);
        this.changexmHandler = this.changexmHandler.bind(this);
    }

    // step 3
    componentDidMount(){

        // step 4
        if(this.state.id === '_add'){
            return
        }else{
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
    }
    saveOrUpdateAsynchronousMachineEquivalentCircuit = (e) => {
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

        // step 5
        if(this.state.id === '_add'){
            asynchronousMachineEquivalentCircuit.asynchronousMachineEquivalentCircuitId=''
            AsynchronousMachineEquivalentCircuitService.createAsynchronousMachineEquivalentCircuit(asynchronousMachineEquivalentCircuit).then(res =>{
                this.props.history.push('/asynchronousMachineEquivalentCircuits');
            });
        }else{
            AsynchronousMachineEquivalentCircuitService.updateAsynchronousMachineEquivalentCircuit(asynchronousMachineEquivalentCircuit).then( res => {
                this.props.history.push('/asynchronousMachineEquivalentCircuits');
            });
        }
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

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add AsynchronousMachineEquivalentCircuit</h3>
        }else{
            return <h3 className="text-center">Update AsynchronousMachineEquivalentCircuit</h3>
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
                                            <label> rr1: </label>
                                            #formFields( $attribute, 'create')
                                            <label> rr2: </label>
                                            #formFields( $attribute, 'create')
                                            <label> xlr1: </label>
                                            #formFields( $attribute, 'create')
                                            <label> xlr2: </label>
                                            #formFields( $attribute, 'create')
                                            <label> xm: </label>
                                            #formFields( $attribute, 'create')
                                        </div>

                                        <button className="btn btn-success" onClick={this.saveOrUpdateAsynchronousMachineEquivalentCircuit}>Save</button>
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

export default CreateAsynchronousMachineEquivalentCircuitComponent
