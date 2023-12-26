import React, { Component } from 'react'
import SynchronousMachineTimeConstantReactanceService from '../services/SynchronousMachineTimeConstantReactanceService';

class UpdateSynchronousMachineTimeConstantReactanceComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
                ks: '',
                modelType: '',
                rotorType: '',
                tc: '',
                tpdo: '',
                tppdo: '',
                tppqo: '',
                tpqo: '',
                xDirectSubtrans: '',
                xDirectSync: '',
                xDirectTrans: '',
                xQuadSubtrans: '',
                xQuadSync: '',
                xQuadTrans: ''
        }
        this.updateSynchronousMachineTimeConstantReactance = this.updateSynchronousMachineTimeConstantReactance.bind(this);

        this.changeksHandler = this.changeksHandler.bind(this);
        this.changemodelTypeHandler = this.changemodelTypeHandler.bind(this);
        this.changerotorTypeHandler = this.changerotorTypeHandler.bind(this);
        this.changetcHandler = this.changetcHandler.bind(this);
        this.changetpdoHandler = this.changetpdoHandler.bind(this);
        this.changetppdoHandler = this.changetppdoHandler.bind(this);
        this.changetppqoHandler = this.changetppqoHandler.bind(this);
        this.changetpqoHandler = this.changetpqoHandler.bind(this);
        this.changexDirectSubtransHandler = this.changexDirectSubtransHandler.bind(this);
        this.changexDirectSyncHandler = this.changexDirectSyncHandler.bind(this);
        this.changexDirectTransHandler = this.changexDirectTransHandler.bind(this);
        this.changexQuadSubtransHandler = this.changexQuadSubtransHandler.bind(this);
        this.changexQuadSyncHandler = this.changexQuadSyncHandler.bind(this);
        this.changexQuadTransHandler = this.changexQuadTransHandler.bind(this);
    }

    componentDidMount(){
        SynchronousMachineTimeConstantReactanceService.getSynchronousMachineTimeConstantReactanceById(this.state.id).then( (res) =>{
            let synchronousMachineTimeConstantReactance = res.data;
            this.setState({
                ks: synchronousMachineTimeConstantReactance.ks,
                modelType: synchronousMachineTimeConstantReactance.modelType,
                rotorType: synchronousMachineTimeConstantReactance.rotorType,
                tc: synchronousMachineTimeConstantReactance.tc,
                tpdo: synchronousMachineTimeConstantReactance.tpdo,
                tppdo: synchronousMachineTimeConstantReactance.tppdo,
                tppqo: synchronousMachineTimeConstantReactance.tppqo,
                tpqo: synchronousMachineTimeConstantReactance.tpqo,
                xDirectSubtrans: synchronousMachineTimeConstantReactance.xDirectSubtrans,
                xDirectSync: synchronousMachineTimeConstantReactance.xDirectSync,
                xDirectTrans: synchronousMachineTimeConstantReactance.xDirectTrans,
                xQuadSubtrans: synchronousMachineTimeConstantReactance.xQuadSubtrans,
                xQuadSync: synchronousMachineTimeConstantReactance.xQuadSync,
                xQuadTrans: synchronousMachineTimeConstantReactance.xQuadTrans
            });
        });
    }

    updateSynchronousMachineTimeConstantReactance = (e) => {
        e.preventDefault();
        let synchronousMachineTimeConstantReactance = {
            synchronousMachineTimeConstantReactanceId: this.state.id,
            ks: this.state.ks,
            modelType: this.state.modelType,
            rotorType: this.state.rotorType,
            tc: this.state.tc,
            tpdo: this.state.tpdo,
            tppdo: this.state.tppdo,
            tppqo: this.state.tppqo,
            tpqo: this.state.tpqo,
            xDirectSubtrans: this.state.xDirectSubtrans,
            xDirectSync: this.state.xDirectSync,
            xDirectTrans: this.state.xDirectTrans,
            xQuadSubtrans: this.state.xQuadSubtrans,
            xQuadSync: this.state.xQuadSync,
            xQuadTrans: this.state.xQuadTrans
        };
        console.log('synchronousMachineTimeConstantReactance => ' + JSON.stringify(synchronousMachineTimeConstantReactance));
        console.log('id => ' + JSON.stringify(this.state.id));
        SynchronousMachineTimeConstantReactanceService.updateSynchronousMachineTimeConstantReactance(synchronousMachineTimeConstantReactance).then( res => {
            this.props.history.push('/synchronousMachineTimeConstantReactances');
        });
    }

    changeksHandler= (event) => {
        this.setState({ks: event.target.value});
    }
    changemodelTypeHandler= (event) => {
        this.setState({modelType: event.target.value});
    }
    changerotorTypeHandler= (event) => {
        this.setState({rotorType: event.target.value});
    }
    changetcHandler= (event) => {
        this.setState({tc: event.target.value});
    }
    changetpdoHandler= (event) => {
        this.setState({tpdo: event.target.value});
    }
    changetppdoHandler= (event) => {
        this.setState({tppdo: event.target.value});
    }
    changetppqoHandler= (event) => {
        this.setState({tppqo: event.target.value});
    }
    changetpqoHandler= (event) => {
        this.setState({tpqo: event.target.value});
    }
    changexDirectSubtransHandler= (event) => {
        this.setState({xDirectSubtrans: event.target.value});
    }
    changexDirectSyncHandler= (event) => {
        this.setState({xDirectSync: event.target.value});
    }
    changexDirectTransHandler= (event) => {
        this.setState({xDirectTrans: event.target.value});
    }
    changexQuadSubtransHandler= (event) => {
        this.setState({xQuadSubtrans: event.target.value});
    }
    changexQuadSyncHandler= (event) => {
        this.setState({xQuadSync: event.target.value});
    }
    changexQuadTransHandler= (event) => {
        this.setState({xQuadTrans: event.target.value});
    }

    cancel(){
        this.props.history.push('/synchronousMachineTimeConstantReactances');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update SynchronousMachineTimeConstantReactance</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                            <label> ks: </label>
                                            #formFields( $attribute, 'update')
                                            <label> modelType: </label>
                                            #formFields( $attribute, 'update')
                                            <label> rotorType: </label>
                                            #formFields( $attribute, 'update')
                                            <label> tc: </label>
                                            #formFields( $attribute, 'update')
                                            <label> tpdo: </label>
                                            #formFields( $attribute, 'update')
                                            <label> tppdo: </label>
                                            #formFields( $attribute, 'update')
                                            <label> tppqo: </label>
                                            #formFields( $attribute, 'update')
                                            <label> tpqo: </label>
                                            #formFields( $attribute, 'update')
                                            <label> xDirectSubtrans: </label>
                                            #formFields( $attribute, 'update')
                                            <label> xDirectSync: </label>
                                            #formFields( $attribute, 'update')
                                            <label> xDirectTrans: </label>
                                            #formFields( $attribute, 'update')
                                            <label> xQuadSubtrans: </label>
                                            #formFields( $attribute, 'update')
                                            <label> xQuadSync: </label>
                                            #formFields( $attribute, 'update')
                                            <label> xQuadTrans: </label>
                                            #formFields( $attribute, 'update')
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateSynchronousMachineTimeConstantReactance}>Save</button>
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

export default UpdateSynchronousMachineTimeConstantReactanceComponent
