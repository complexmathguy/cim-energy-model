import React, { Component } from 'react'
import TurbLCFB1Service from '../services/TurbLCFB1Service';

class UpdateTurbLCFB1Component extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
                db: '',
                emax: '',
                fb: '',
                fbf: '',
                irmax: '',
                ki: '',
                kp: '',
                mwbase: '',
                pbf: '',
                pmwset: '',
                speedReferenceGovernor: '',
                tpelec: ''
        }
        this.updateTurbLCFB1 = this.updateTurbLCFB1.bind(this);

        this.changedbHandler = this.changedbHandler.bind(this);
        this.changeemaxHandler = this.changeemaxHandler.bind(this);
        this.changefbHandler = this.changefbHandler.bind(this);
        this.changefbfHandler = this.changefbfHandler.bind(this);
        this.changeirmaxHandler = this.changeirmaxHandler.bind(this);
        this.changekiHandler = this.changekiHandler.bind(this);
        this.changekpHandler = this.changekpHandler.bind(this);
        this.changemwbaseHandler = this.changemwbaseHandler.bind(this);
        this.changepbfHandler = this.changepbfHandler.bind(this);
        this.changepmwsetHandler = this.changepmwsetHandler.bind(this);
        this.changespeedReferenceGovernorHandler = this.changespeedReferenceGovernorHandler.bind(this);
        this.changetpelecHandler = this.changetpelecHandler.bind(this);
    }

    componentDidMount(){
        TurbLCFB1Service.getTurbLCFB1ById(this.state.id).then( (res) =>{
            let turbLCFB1 = res.data;
            this.setState({
                db: turbLCFB1.db,
                emax: turbLCFB1.emax,
                fb: turbLCFB1.fb,
                fbf: turbLCFB1.fbf,
                irmax: turbLCFB1.irmax,
                ki: turbLCFB1.ki,
                kp: turbLCFB1.kp,
                mwbase: turbLCFB1.mwbase,
                pbf: turbLCFB1.pbf,
                pmwset: turbLCFB1.pmwset,
                speedReferenceGovernor: turbLCFB1.speedReferenceGovernor,
                tpelec: turbLCFB1.tpelec
            });
        });
    }

    updateTurbLCFB1 = (e) => {
        e.preventDefault();
        let turbLCFB1 = {
            turbLCFB1Id: this.state.id,
            db: this.state.db,
            emax: this.state.emax,
            fb: this.state.fb,
            fbf: this.state.fbf,
            irmax: this.state.irmax,
            ki: this.state.ki,
            kp: this.state.kp,
            mwbase: this.state.mwbase,
            pbf: this.state.pbf,
            pmwset: this.state.pmwset,
            speedReferenceGovernor: this.state.speedReferenceGovernor,
            tpelec: this.state.tpelec
        };
        console.log('turbLCFB1 => ' + JSON.stringify(turbLCFB1));
        console.log('id => ' + JSON.stringify(this.state.id));
        TurbLCFB1Service.updateTurbLCFB1(turbLCFB1).then( res => {
            this.props.history.push('/turbLCFB1s');
        });
    }

    changedbHandler= (event) => {
        this.setState({db: event.target.value});
    }
    changeemaxHandler= (event) => {
        this.setState({emax: event.target.value});
    }
    changefbHandler= (event) => {
        this.setState({fb: event.target.value});
    }
    changefbfHandler= (event) => {
        this.setState({fbf: event.target.value});
    }
    changeirmaxHandler= (event) => {
        this.setState({irmax: event.target.value});
    }
    changekiHandler= (event) => {
        this.setState({ki: event.target.value});
    }
    changekpHandler= (event) => {
        this.setState({kp: event.target.value});
    }
    changemwbaseHandler= (event) => {
        this.setState({mwbase: event.target.value});
    }
    changepbfHandler= (event) => {
        this.setState({pbf: event.target.value});
    }
    changepmwsetHandler= (event) => {
        this.setState({pmwset: event.target.value});
    }
    changespeedReferenceGovernorHandler= (event) => {
        this.setState({speedReferenceGovernor: event.target.value});
    }
    changetpelecHandler= (event) => {
        this.setState({tpelec: event.target.value});
    }

    cancel(){
        this.props.history.push('/turbLCFB1s');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update TurbLCFB1</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                            <label> db: </label>
                                            #formFields( $attribute, 'update')
                                            <label> emax: </label>
                                            #formFields( $attribute, 'update')
                                            <label> fb: </label>
                                            #formFields( $attribute, 'update')
                                            <label> fbf: </label>
                                            #formFields( $attribute, 'update')
                                            <label> irmax: </label>
                                            #formFields( $attribute, 'update')
                                            <label> ki: </label>
                                            #formFields( $attribute, 'update')
                                            <label> kp: </label>
                                            #formFields( $attribute, 'update')
                                            <label> mwbase: </label>
                                            #formFields( $attribute, 'update')
                                            <label> pbf: </label>
                                            #formFields( $attribute, 'update')
                                            <label> pmwset: </label>
                                            #formFields( $attribute, 'update')
                                            <label> speedReferenceGovernor: </label>
                                            #formFields( $attribute, 'update')
                                            <label> tpelec: </label>
                                            #formFields( $attribute, 'update')
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateTurbLCFB1}>Save</button>
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

export default UpdateTurbLCFB1Component
