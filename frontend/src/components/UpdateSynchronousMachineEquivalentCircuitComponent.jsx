import React, { Component } from 'react'
import SynchronousMachineEquivalentCircuitService from '../services/SynchronousMachineEquivalentCircuitService';

class UpdateSynchronousMachineEquivalentCircuitComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
                r1d: '',
                r1q: '',
                r2q: '',
                rfd: '',
                x1d: '',
                x1q: '',
                x2q: '',
                xad: '',
                xaq: '',
                xf1d: '',
                xfd: ''
        }
        this.updateSynchronousMachineEquivalentCircuit = this.updateSynchronousMachineEquivalentCircuit.bind(this);

        this.changer1dHandler = this.changer1dHandler.bind(this);
        this.changer1qHandler = this.changer1qHandler.bind(this);
        this.changer2qHandler = this.changer2qHandler.bind(this);
        this.changerfdHandler = this.changerfdHandler.bind(this);
        this.changex1dHandler = this.changex1dHandler.bind(this);
        this.changex1qHandler = this.changex1qHandler.bind(this);
        this.changex2qHandler = this.changex2qHandler.bind(this);
        this.changexadHandler = this.changexadHandler.bind(this);
        this.changexaqHandler = this.changexaqHandler.bind(this);
        this.changexf1dHandler = this.changexf1dHandler.bind(this);
        this.changexfdHandler = this.changexfdHandler.bind(this);
    }

    componentDidMount(){
        SynchronousMachineEquivalentCircuitService.getSynchronousMachineEquivalentCircuitById(this.state.id).then( (res) =>{
            let synchronousMachineEquivalentCircuit = res.data;
            this.setState({
                r1d: synchronousMachineEquivalentCircuit.r1d,
                r1q: synchronousMachineEquivalentCircuit.r1q,
                r2q: synchronousMachineEquivalentCircuit.r2q,
                rfd: synchronousMachineEquivalentCircuit.rfd,
                x1d: synchronousMachineEquivalentCircuit.x1d,
                x1q: synchronousMachineEquivalentCircuit.x1q,
                x2q: synchronousMachineEquivalentCircuit.x2q,
                xad: synchronousMachineEquivalentCircuit.xad,
                xaq: synchronousMachineEquivalentCircuit.xaq,
                xf1d: synchronousMachineEquivalentCircuit.xf1d,
                xfd: synchronousMachineEquivalentCircuit.xfd
            });
        });
    }

    updateSynchronousMachineEquivalentCircuit = (e) => {
        e.preventDefault();
        let synchronousMachineEquivalentCircuit = {
            synchronousMachineEquivalentCircuitId: this.state.id,
            r1d: this.state.r1d,
            r1q: this.state.r1q,
            r2q: this.state.r2q,
            rfd: this.state.rfd,
            x1d: this.state.x1d,
            x1q: this.state.x1q,
            x2q: this.state.x2q,
            xad: this.state.xad,
            xaq: this.state.xaq,
            xf1d: this.state.xf1d,
            xfd: this.state.xfd
        };
        console.log('synchronousMachineEquivalentCircuit => ' + JSON.stringify(synchronousMachineEquivalentCircuit));
        console.log('id => ' + JSON.stringify(this.state.id));
        SynchronousMachineEquivalentCircuitService.updateSynchronousMachineEquivalentCircuit(synchronousMachineEquivalentCircuit).then( res => {
            this.props.history.push('/synchronousMachineEquivalentCircuits');
        });
    }

    changer1dHandler= (event) => {
        this.setState({r1d: event.target.value});
    }
    changer1qHandler= (event) => {
        this.setState({r1q: event.target.value});
    }
    changer2qHandler= (event) => {
        this.setState({r2q: event.target.value});
    }
    changerfdHandler= (event) => {
        this.setState({rfd: event.target.value});
    }
    changex1dHandler= (event) => {
        this.setState({x1d: event.target.value});
    }
    changex1qHandler= (event) => {
        this.setState({x1q: event.target.value});
    }
    changex2qHandler= (event) => {
        this.setState({x2q: event.target.value});
    }
    changexadHandler= (event) => {
        this.setState({xad: event.target.value});
    }
    changexaqHandler= (event) => {
        this.setState({xaq: event.target.value});
    }
    changexf1dHandler= (event) => {
        this.setState({xf1d: event.target.value});
    }
    changexfdHandler= (event) => {
        this.setState({xfd: event.target.value});
    }

    cancel(){
        this.props.history.push('/synchronousMachineEquivalentCircuits');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update SynchronousMachineEquivalentCircuit</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                            <label> r1d: </label>
                                            #formFields( $attribute, 'update')
                                            <label> r1q: </label>
                                            #formFields( $attribute, 'update')
                                            <label> r2q: </label>
                                            #formFields( $attribute, 'update')
                                            <label> rfd: </label>
                                            #formFields( $attribute, 'update')
                                            <label> x1d: </label>
                                            #formFields( $attribute, 'update')
                                            <label> x1q: </label>
                                            #formFields( $attribute, 'update')
                                            <label> x2q: </label>
                                            #formFields( $attribute, 'update')
                                            <label> xad: </label>
                                            #formFields( $attribute, 'update')
                                            <label> xaq: </label>
                                            #formFields( $attribute, 'update')
                                            <label> xf1d: </label>
                                            #formFields( $attribute, 'update')
                                            <label> xfd: </label>
                                            #formFields( $attribute, 'update')
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateSynchronousMachineEquivalentCircuit}>Save</button>
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

export default UpdateSynchronousMachineEquivalentCircuitComponent
