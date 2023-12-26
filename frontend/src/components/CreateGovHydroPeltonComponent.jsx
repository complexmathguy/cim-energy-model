import React, { Component } from 'react'
import GovHydroPeltonService from '../services/GovHydroPeltonService';

class CreateGovHydroPeltonComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            // step 2
            id: this.props.match.params.id,
                av0: '',
                av1: '',
                bp: '',
                db1: '',
                db2: '',
                h1: '',
                h2: '',
                hn: '',
                kc: '',
                kg: '',
                qc0: '',
                qn: '',
                simplifiedPelton: '',
                staticCompensating: '',
                ta: '',
                ts: '',
                tv: '',
                twnc: '',
                twng: '',
                tx: '',
                va: '',
                valvmax: '',
                valvmin: '',
                vav: '',
                vc: '',
                vcv: '',
                waterTunnelSurgeChamberSimulation: '',
                zsfc: ''
        }
        this.changeav0Handler = this.changeav0Handler.bind(this);
        this.changeav1Handler = this.changeav1Handler.bind(this);
        this.changebpHandler = this.changebpHandler.bind(this);
        this.changedb1Handler = this.changedb1Handler.bind(this);
        this.changedb2Handler = this.changedb2Handler.bind(this);
        this.changeh1Handler = this.changeh1Handler.bind(this);
        this.changeh2Handler = this.changeh2Handler.bind(this);
        this.changehnHandler = this.changehnHandler.bind(this);
        this.changekcHandler = this.changekcHandler.bind(this);
        this.changekgHandler = this.changekgHandler.bind(this);
        this.changeqc0Handler = this.changeqc0Handler.bind(this);
        this.changeqnHandler = this.changeqnHandler.bind(this);
        this.changesimplifiedPeltonHandler = this.changesimplifiedPeltonHandler.bind(this);
        this.changestaticCompensatingHandler = this.changestaticCompensatingHandler.bind(this);
        this.changetaHandler = this.changetaHandler.bind(this);
        this.changetsHandler = this.changetsHandler.bind(this);
        this.changetvHandler = this.changetvHandler.bind(this);
        this.changetwncHandler = this.changetwncHandler.bind(this);
        this.changetwngHandler = this.changetwngHandler.bind(this);
        this.changetxHandler = this.changetxHandler.bind(this);
        this.changevaHandler = this.changevaHandler.bind(this);
        this.changevalvmaxHandler = this.changevalvmaxHandler.bind(this);
        this.changevalvminHandler = this.changevalvminHandler.bind(this);
        this.changevavHandler = this.changevavHandler.bind(this);
        this.changevcHandler = this.changevcHandler.bind(this);
        this.changevcvHandler = this.changevcvHandler.bind(this);
        this.changewaterTunnelSurgeChamberSimulationHandler = this.changewaterTunnelSurgeChamberSimulationHandler.bind(this);
        this.changezsfcHandler = this.changezsfcHandler.bind(this);
    }

    // step 3
    componentDidMount(){

        // step 4
        if(this.state.id === '_add'){
            return
        }else{
            GovHydroPeltonService.getGovHydroPeltonById(this.state.id).then( (res) =>{
                let govHydroPelton = res.data;
                this.setState({
                    av0: govHydroPelton.av0,
                    av1: govHydroPelton.av1,
                    bp: govHydroPelton.bp,
                    db1: govHydroPelton.db1,
                    db2: govHydroPelton.db2,
                    h1: govHydroPelton.h1,
                    h2: govHydroPelton.h2,
                    hn: govHydroPelton.hn,
                    kc: govHydroPelton.kc,
                    kg: govHydroPelton.kg,
                    qc0: govHydroPelton.qc0,
                    qn: govHydroPelton.qn,
                    simplifiedPelton: govHydroPelton.simplifiedPelton,
                    staticCompensating: govHydroPelton.staticCompensating,
                    ta: govHydroPelton.ta,
                    ts: govHydroPelton.ts,
                    tv: govHydroPelton.tv,
                    twnc: govHydroPelton.twnc,
                    twng: govHydroPelton.twng,
                    tx: govHydroPelton.tx,
                    va: govHydroPelton.va,
                    valvmax: govHydroPelton.valvmax,
                    valvmin: govHydroPelton.valvmin,
                    vav: govHydroPelton.vav,
                    vc: govHydroPelton.vc,
                    vcv: govHydroPelton.vcv,
                    waterTunnelSurgeChamberSimulation: govHydroPelton.waterTunnelSurgeChamberSimulation,
                    zsfc: govHydroPelton.zsfc
                });
            });
        }        
    }
    saveOrUpdateGovHydroPelton = (e) => {
        e.preventDefault();
        let govHydroPelton = {
                govHydroPeltonId: this.state.id,
                av0: this.state.av0,
                av1: this.state.av1,
                bp: this.state.bp,
                db1: this.state.db1,
                db2: this.state.db2,
                h1: this.state.h1,
                h2: this.state.h2,
                hn: this.state.hn,
                kc: this.state.kc,
                kg: this.state.kg,
                qc0: this.state.qc0,
                qn: this.state.qn,
                simplifiedPelton: this.state.simplifiedPelton,
                staticCompensating: this.state.staticCompensating,
                ta: this.state.ta,
                ts: this.state.ts,
                tv: this.state.tv,
                twnc: this.state.twnc,
                twng: this.state.twng,
                tx: this.state.tx,
                va: this.state.va,
                valvmax: this.state.valvmax,
                valvmin: this.state.valvmin,
                vav: this.state.vav,
                vc: this.state.vc,
                vcv: this.state.vcv,
                waterTunnelSurgeChamberSimulation: this.state.waterTunnelSurgeChamberSimulation,
                zsfc: this.state.zsfc
            };
        console.log('govHydroPelton => ' + JSON.stringify(govHydroPelton));

        // step 5
        if(this.state.id === '_add'){
            govHydroPelton.govHydroPeltonId=''
            GovHydroPeltonService.createGovHydroPelton(govHydroPelton).then(res =>{
                this.props.history.push('/govHydroPeltons');
            });
        }else{
            GovHydroPeltonService.updateGovHydroPelton(govHydroPelton).then( res => {
                this.props.history.push('/govHydroPeltons');
            });
        }
    }
    
    changeav0Handler= (event) => {
        this.setState({av0: event.target.value});
    }
    changeav1Handler= (event) => {
        this.setState({av1: event.target.value});
    }
    changebpHandler= (event) => {
        this.setState({bp: event.target.value});
    }
    changedb1Handler= (event) => {
        this.setState({db1: event.target.value});
    }
    changedb2Handler= (event) => {
        this.setState({db2: event.target.value});
    }
    changeh1Handler= (event) => {
        this.setState({h1: event.target.value});
    }
    changeh2Handler= (event) => {
        this.setState({h2: event.target.value});
    }
    changehnHandler= (event) => {
        this.setState({hn: event.target.value});
    }
    changekcHandler= (event) => {
        this.setState({kc: event.target.value});
    }
    changekgHandler= (event) => {
        this.setState({kg: event.target.value});
    }
    changeqc0Handler= (event) => {
        this.setState({qc0: event.target.value});
    }
    changeqnHandler= (event) => {
        this.setState({qn: event.target.value});
    }
    changesimplifiedPeltonHandler= (event) => {
        this.setState({simplifiedPelton: event.target.value});
    }
    changestaticCompensatingHandler= (event) => {
        this.setState({staticCompensating: event.target.value});
    }
    changetaHandler= (event) => {
        this.setState({ta: event.target.value});
    }
    changetsHandler= (event) => {
        this.setState({ts: event.target.value});
    }
    changetvHandler= (event) => {
        this.setState({tv: event.target.value});
    }
    changetwncHandler= (event) => {
        this.setState({twnc: event.target.value});
    }
    changetwngHandler= (event) => {
        this.setState({twng: event.target.value});
    }
    changetxHandler= (event) => {
        this.setState({tx: event.target.value});
    }
    changevaHandler= (event) => {
        this.setState({va: event.target.value});
    }
    changevalvmaxHandler= (event) => {
        this.setState({valvmax: event.target.value});
    }
    changevalvminHandler= (event) => {
        this.setState({valvmin: event.target.value});
    }
    changevavHandler= (event) => {
        this.setState({vav: event.target.value});
    }
    changevcHandler= (event) => {
        this.setState({vc: event.target.value});
    }
    changevcvHandler= (event) => {
        this.setState({vcv: event.target.value});
    }
    changewaterTunnelSurgeChamberSimulationHandler= (event) => {
        this.setState({waterTunnelSurgeChamberSimulation: event.target.value});
    }
    changezsfcHandler= (event) => {
        this.setState({zsfc: event.target.value});
    }

    cancel(){
        this.props.history.push('/govHydroPeltons');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add GovHydroPelton</h3>
        }else{
            return <h3 className="text-center">Update GovHydroPelton</h3>
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
                                            <label> av0: </label>
                                            #formFields( $attribute, 'create')
                                            <label> av1: </label>
                                            #formFields( $attribute, 'create')
                                            <label> bp: </label>
                                            #formFields( $attribute, 'create')
                                            <label> db1: </label>
                                            #formFields( $attribute, 'create')
                                            <label> db2: </label>
                                            #formFields( $attribute, 'create')
                                            <label> h1: </label>
                                            #formFields( $attribute, 'create')
                                            <label> h2: </label>
                                            #formFields( $attribute, 'create')
                                            <label> hn: </label>
                                            #formFields( $attribute, 'create')
                                            <label> kc: </label>
                                            #formFields( $attribute, 'create')
                                            <label> kg: </label>
                                            #formFields( $attribute, 'create')
                                            <label> qc0: </label>
                                            #formFields( $attribute, 'create')
                                            <label> qn: </label>
                                            #formFields( $attribute, 'create')
                                            <label> simplifiedPelton: </label>
                                            #formFields( $attribute, 'create')
                                            <label> staticCompensating: </label>
                                            #formFields( $attribute, 'create')
                                            <label> ta: </label>
                                            #formFields( $attribute, 'create')
                                            <label> ts: </label>
                                            #formFields( $attribute, 'create')
                                            <label> tv: </label>
                                            #formFields( $attribute, 'create')
                                            <label> twnc: </label>
                                            #formFields( $attribute, 'create')
                                            <label> twng: </label>
                                            #formFields( $attribute, 'create')
                                            <label> tx: </label>
                                            #formFields( $attribute, 'create')
                                            <label> va: </label>
                                            #formFields( $attribute, 'create')
                                            <label> valvmax: </label>
                                            #formFields( $attribute, 'create')
                                            <label> valvmin: </label>
                                            #formFields( $attribute, 'create')
                                            <label> vav: </label>
                                            #formFields( $attribute, 'create')
                                            <label> vc: </label>
                                            #formFields( $attribute, 'create')
                                            <label> vcv: </label>
                                            #formFields( $attribute, 'create')
                                            <label> waterTunnelSurgeChamberSimulation: </label>
                                            #formFields( $attribute, 'create')
                                            <label> zsfc: </label>
                                            #formFields( $attribute, 'create')
                                        </div>

                                        <button className="btn btn-success" onClick={this.saveOrUpdateGovHydroPelton}>Save</button>
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

export default CreateGovHydroPeltonComponent
