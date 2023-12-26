import React, { Component } from 'react'
import GovHydroDDService from '../services/GovHydroDDService';

class CreateGovHydroDDComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            // step 2
            id: this.props.match.params.id,
                aturb: '',
                bturb: '',
                db1: '',
                db2: '',
                eps: '',
                gmax: '',
                gmin: '',
                gv1: '',
                gv2: '',
                gv3: '',
                gv4: '',
                gv5: '',
                gv6: '',
                inputSignal: '',
                k1: '',
                k2: '',
                kg: '',
                ki: '',
                mwbase: '',
                pgv1: '',
                pgv2: '',
                pgv3: '',
                pgv4: '',
                pgv5: '',
                pgv6: '',
                pmax: '',
                pmin: '',
                r: '',
                td: '',
                tf: '',
                tp: '',
                tt: '',
                tturb: '',
                velcl: '',
                velop: ''
        }
        this.changeaturbHandler = this.changeaturbHandler.bind(this);
        this.changebturbHandler = this.changebturbHandler.bind(this);
        this.changedb1Handler = this.changedb1Handler.bind(this);
        this.changedb2Handler = this.changedb2Handler.bind(this);
        this.changeepsHandler = this.changeepsHandler.bind(this);
        this.changegmaxHandler = this.changegmaxHandler.bind(this);
        this.changegminHandler = this.changegminHandler.bind(this);
        this.changegv1Handler = this.changegv1Handler.bind(this);
        this.changegv2Handler = this.changegv2Handler.bind(this);
        this.changegv3Handler = this.changegv3Handler.bind(this);
        this.changegv4Handler = this.changegv4Handler.bind(this);
        this.changegv5Handler = this.changegv5Handler.bind(this);
        this.changegv6Handler = this.changegv6Handler.bind(this);
        this.changeinputSignalHandler = this.changeinputSignalHandler.bind(this);
        this.changek1Handler = this.changek1Handler.bind(this);
        this.changek2Handler = this.changek2Handler.bind(this);
        this.changekgHandler = this.changekgHandler.bind(this);
        this.changekiHandler = this.changekiHandler.bind(this);
        this.changemwbaseHandler = this.changemwbaseHandler.bind(this);
        this.changepgv1Handler = this.changepgv1Handler.bind(this);
        this.changepgv2Handler = this.changepgv2Handler.bind(this);
        this.changepgv3Handler = this.changepgv3Handler.bind(this);
        this.changepgv4Handler = this.changepgv4Handler.bind(this);
        this.changepgv5Handler = this.changepgv5Handler.bind(this);
        this.changepgv6Handler = this.changepgv6Handler.bind(this);
        this.changepmaxHandler = this.changepmaxHandler.bind(this);
        this.changepminHandler = this.changepminHandler.bind(this);
        this.changerHandler = this.changerHandler.bind(this);
        this.changetdHandler = this.changetdHandler.bind(this);
        this.changetfHandler = this.changetfHandler.bind(this);
        this.changetpHandler = this.changetpHandler.bind(this);
        this.changettHandler = this.changettHandler.bind(this);
        this.changetturbHandler = this.changetturbHandler.bind(this);
        this.changevelclHandler = this.changevelclHandler.bind(this);
        this.changevelopHandler = this.changevelopHandler.bind(this);
    }

    // step 3
    componentDidMount(){

        // step 4
        if(this.state.id === '_add'){
            return
        }else{
            GovHydroDDService.getGovHydroDDById(this.state.id).then( (res) =>{
                let govHydroDD = res.data;
                this.setState({
                    aturb: govHydroDD.aturb,
                    bturb: govHydroDD.bturb,
                    db1: govHydroDD.db1,
                    db2: govHydroDD.db2,
                    eps: govHydroDD.eps,
                    gmax: govHydroDD.gmax,
                    gmin: govHydroDD.gmin,
                    gv1: govHydroDD.gv1,
                    gv2: govHydroDD.gv2,
                    gv3: govHydroDD.gv3,
                    gv4: govHydroDD.gv4,
                    gv5: govHydroDD.gv5,
                    gv6: govHydroDD.gv6,
                    inputSignal: govHydroDD.inputSignal,
                    k1: govHydroDD.k1,
                    k2: govHydroDD.k2,
                    kg: govHydroDD.kg,
                    ki: govHydroDD.ki,
                    mwbase: govHydroDD.mwbase,
                    pgv1: govHydroDD.pgv1,
                    pgv2: govHydroDD.pgv2,
                    pgv3: govHydroDD.pgv3,
                    pgv4: govHydroDD.pgv4,
                    pgv5: govHydroDD.pgv5,
                    pgv6: govHydroDD.pgv6,
                    pmax: govHydroDD.pmax,
                    pmin: govHydroDD.pmin,
                    r: govHydroDD.r,
                    td: govHydroDD.td,
                    tf: govHydroDD.tf,
                    tp: govHydroDD.tp,
                    tt: govHydroDD.tt,
                    tturb: govHydroDD.tturb,
                    velcl: govHydroDD.velcl,
                    velop: govHydroDD.velop
                });
            });
        }        
    }
    saveOrUpdateGovHydroDD = (e) => {
        e.preventDefault();
        let govHydroDD = {
                govHydroDDId: this.state.id,
                aturb: this.state.aturb,
                bturb: this.state.bturb,
                db1: this.state.db1,
                db2: this.state.db2,
                eps: this.state.eps,
                gmax: this.state.gmax,
                gmin: this.state.gmin,
                gv1: this.state.gv1,
                gv2: this.state.gv2,
                gv3: this.state.gv3,
                gv4: this.state.gv4,
                gv5: this.state.gv5,
                gv6: this.state.gv6,
                inputSignal: this.state.inputSignal,
                k1: this.state.k1,
                k2: this.state.k2,
                kg: this.state.kg,
                ki: this.state.ki,
                mwbase: this.state.mwbase,
                pgv1: this.state.pgv1,
                pgv2: this.state.pgv2,
                pgv3: this.state.pgv3,
                pgv4: this.state.pgv4,
                pgv5: this.state.pgv5,
                pgv6: this.state.pgv6,
                pmax: this.state.pmax,
                pmin: this.state.pmin,
                r: this.state.r,
                td: this.state.td,
                tf: this.state.tf,
                tp: this.state.tp,
                tt: this.state.tt,
                tturb: this.state.tturb,
                velcl: this.state.velcl,
                velop: this.state.velop
            };
        console.log('govHydroDD => ' + JSON.stringify(govHydroDD));

        // step 5
        if(this.state.id === '_add'){
            govHydroDD.govHydroDDId=''
            GovHydroDDService.createGovHydroDD(govHydroDD).then(res =>{
                this.props.history.push('/govHydroDDs');
            });
        }else{
            GovHydroDDService.updateGovHydroDD(govHydroDD).then( res => {
                this.props.history.push('/govHydroDDs');
            });
        }
    }
    
    changeaturbHandler= (event) => {
        this.setState({aturb: event.target.value});
    }
    changebturbHandler= (event) => {
        this.setState({bturb: event.target.value});
    }
    changedb1Handler= (event) => {
        this.setState({db1: event.target.value});
    }
    changedb2Handler= (event) => {
        this.setState({db2: event.target.value});
    }
    changeepsHandler= (event) => {
        this.setState({eps: event.target.value});
    }
    changegmaxHandler= (event) => {
        this.setState({gmax: event.target.value});
    }
    changegminHandler= (event) => {
        this.setState({gmin: event.target.value});
    }
    changegv1Handler= (event) => {
        this.setState({gv1: event.target.value});
    }
    changegv2Handler= (event) => {
        this.setState({gv2: event.target.value});
    }
    changegv3Handler= (event) => {
        this.setState({gv3: event.target.value});
    }
    changegv4Handler= (event) => {
        this.setState({gv4: event.target.value});
    }
    changegv5Handler= (event) => {
        this.setState({gv5: event.target.value});
    }
    changegv6Handler= (event) => {
        this.setState({gv6: event.target.value});
    }
    changeinputSignalHandler= (event) => {
        this.setState({inputSignal: event.target.value});
    }
    changek1Handler= (event) => {
        this.setState({k1: event.target.value});
    }
    changek2Handler= (event) => {
        this.setState({k2: event.target.value});
    }
    changekgHandler= (event) => {
        this.setState({kg: event.target.value});
    }
    changekiHandler= (event) => {
        this.setState({ki: event.target.value});
    }
    changemwbaseHandler= (event) => {
        this.setState({mwbase: event.target.value});
    }
    changepgv1Handler= (event) => {
        this.setState({pgv1: event.target.value});
    }
    changepgv2Handler= (event) => {
        this.setState({pgv2: event.target.value});
    }
    changepgv3Handler= (event) => {
        this.setState({pgv3: event.target.value});
    }
    changepgv4Handler= (event) => {
        this.setState({pgv4: event.target.value});
    }
    changepgv5Handler= (event) => {
        this.setState({pgv5: event.target.value});
    }
    changepgv6Handler= (event) => {
        this.setState({pgv6: event.target.value});
    }
    changepmaxHandler= (event) => {
        this.setState({pmax: event.target.value});
    }
    changepminHandler= (event) => {
        this.setState({pmin: event.target.value});
    }
    changerHandler= (event) => {
        this.setState({r: event.target.value});
    }
    changetdHandler= (event) => {
        this.setState({td: event.target.value});
    }
    changetfHandler= (event) => {
        this.setState({tf: event.target.value});
    }
    changetpHandler= (event) => {
        this.setState({tp: event.target.value});
    }
    changettHandler= (event) => {
        this.setState({tt: event.target.value});
    }
    changetturbHandler= (event) => {
        this.setState({tturb: event.target.value});
    }
    changevelclHandler= (event) => {
        this.setState({velcl: event.target.value});
    }
    changevelopHandler= (event) => {
        this.setState({velop: event.target.value});
    }

    cancel(){
        this.props.history.push('/govHydroDDs');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add GovHydroDD</h3>
        }else{
            return <h3 className="text-center">Update GovHydroDD</h3>
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
                                            <label> aturb: </label>
                                            #formFields( $attribute, 'create')
                                            <label> bturb: </label>
                                            #formFields( $attribute, 'create')
                                            <label> db1: </label>
                                            #formFields( $attribute, 'create')
                                            <label> db2: </label>
                                            #formFields( $attribute, 'create')
                                            <label> eps: </label>
                                            #formFields( $attribute, 'create')
                                            <label> gmax: </label>
                                            #formFields( $attribute, 'create')
                                            <label> gmin: </label>
                                            #formFields( $attribute, 'create')
                                            <label> gv1: </label>
                                            #formFields( $attribute, 'create')
                                            <label> gv2: </label>
                                            #formFields( $attribute, 'create')
                                            <label> gv3: </label>
                                            #formFields( $attribute, 'create')
                                            <label> gv4: </label>
                                            #formFields( $attribute, 'create')
                                            <label> gv5: </label>
                                            #formFields( $attribute, 'create')
                                            <label> gv6: </label>
                                            #formFields( $attribute, 'create')
                                            <label> inputSignal: </label>
                                            #formFields( $attribute, 'create')
                                            <label> k1: </label>
                                            #formFields( $attribute, 'create')
                                            <label> k2: </label>
                                            #formFields( $attribute, 'create')
                                            <label> kg: </label>
                                            #formFields( $attribute, 'create')
                                            <label> ki: </label>
                                            #formFields( $attribute, 'create')
                                            <label> mwbase: </label>
                                            #formFields( $attribute, 'create')
                                            <label> pgv1: </label>
                                            #formFields( $attribute, 'create')
                                            <label> pgv2: </label>
                                            #formFields( $attribute, 'create')
                                            <label> pgv3: </label>
                                            #formFields( $attribute, 'create')
                                            <label> pgv4: </label>
                                            #formFields( $attribute, 'create')
                                            <label> pgv5: </label>
                                            #formFields( $attribute, 'create')
                                            <label> pgv6: </label>
                                            #formFields( $attribute, 'create')
                                            <label> pmax: </label>
                                            #formFields( $attribute, 'create')
                                            <label> pmin: </label>
                                            #formFields( $attribute, 'create')
                                            <label> r: </label>
                                            #formFields( $attribute, 'create')
                                            <label> td: </label>
                                            #formFields( $attribute, 'create')
                                            <label> tf: </label>
                                            #formFields( $attribute, 'create')
                                            <label> tp: </label>
                                            #formFields( $attribute, 'create')
                                            <label> tt: </label>
                                            #formFields( $attribute, 'create')
                                            <label> tturb: </label>
                                            #formFields( $attribute, 'create')
                                            <label> velcl: </label>
                                            #formFields( $attribute, 'create')
                                            <label> velop: </label>
                                            #formFields( $attribute, 'create')
                                        </div>

                                        <button className="btn btn-success" onClick={this.saveOrUpdateGovHydroDD}>Save</button>
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

export default CreateGovHydroDDComponent
