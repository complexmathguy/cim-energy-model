import React, { Component } from 'react'
import GovGASTWDService from '../services/GovGASTWDService';

class UpdateGovGASTWDComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
                a: '',
                af1: '',
                af2: '',
                b: '',
                bf1: '',
                bf2: '',
                c: '',
                cf2: '',
                ecr: '',
                etd: '',
                k3: '',
                k4: '',
                k5: '',
                k6: '',
                kd: '',
                kdroop: '',
                kf: '',
                ki: '',
                kp: '',
                mwbase: '',
                t: '',
                t3: '',
                t4: '',
                t5: '',
                tc: '',
                tcd: '',
                td: '',
                tf: '',
                tmax: '',
                tmin: '',
                tr: '',
                trate: '',
                tt: ''
        }
        this.updateGovGASTWD = this.updateGovGASTWD.bind(this);

        this.changeaHandler = this.changeaHandler.bind(this);
        this.changeaf1Handler = this.changeaf1Handler.bind(this);
        this.changeaf2Handler = this.changeaf2Handler.bind(this);
        this.changebHandler = this.changebHandler.bind(this);
        this.changebf1Handler = this.changebf1Handler.bind(this);
        this.changebf2Handler = this.changebf2Handler.bind(this);
        this.changecHandler = this.changecHandler.bind(this);
        this.changecf2Handler = this.changecf2Handler.bind(this);
        this.changeecrHandler = this.changeecrHandler.bind(this);
        this.changeetdHandler = this.changeetdHandler.bind(this);
        this.changek3Handler = this.changek3Handler.bind(this);
        this.changek4Handler = this.changek4Handler.bind(this);
        this.changek5Handler = this.changek5Handler.bind(this);
        this.changek6Handler = this.changek6Handler.bind(this);
        this.changekdHandler = this.changekdHandler.bind(this);
        this.changekdroopHandler = this.changekdroopHandler.bind(this);
        this.changekfHandler = this.changekfHandler.bind(this);
        this.changekiHandler = this.changekiHandler.bind(this);
        this.changekpHandler = this.changekpHandler.bind(this);
        this.changemwbaseHandler = this.changemwbaseHandler.bind(this);
        this.changetHandler = this.changetHandler.bind(this);
        this.changet3Handler = this.changet3Handler.bind(this);
        this.changet4Handler = this.changet4Handler.bind(this);
        this.changet5Handler = this.changet5Handler.bind(this);
        this.changetcHandler = this.changetcHandler.bind(this);
        this.changetcdHandler = this.changetcdHandler.bind(this);
        this.changetdHandler = this.changetdHandler.bind(this);
        this.changetfHandler = this.changetfHandler.bind(this);
        this.changetmaxHandler = this.changetmaxHandler.bind(this);
        this.changetminHandler = this.changetminHandler.bind(this);
        this.changetrHandler = this.changetrHandler.bind(this);
        this.changetrateHandler = this.changetrateHandler.bind(this);
        this.changettHandler = this.changettHandler.bind(this);
    }

    componentDidMount(){
        GovGASTWDService.getGovGASTWDById(this.state.id).then( (res) =>{
            let govGASTWD = res.data;
            this.setState({
                a: govGASTWD.a,
                af1: govGASTWD.af1,
                af2: govGASTWD.af2,
                b: govGASTWD.b,
                bf1: govGASTWD.bf1,
                bf2: govGASTWD.bf2,
                c: govGASTWD.c,
                cf2: govGASTWD.cf2,
                ecr: govGASTWD.ecr,
                etd: govGASTWD.etd,
                k3: govGASTWD.k3,
                k4: govGASTWD.k4,
                k5: govGASTWD.k5,
                k6: govGASTWD.k6,
                kd: govGASTWD.kd,
                kdroop: govGASTWD.kdroop,
                kf: govGASTWD.kf,
                ki: govGASTWD.ki,
                kp: govGASTWD.kp,
                mwbase: govGASTWD.mwbase,
                t: govGASTWD.t,
                t3: govGASTWD.t3,
                t4: govGASTWD.t4,
                t5: govGASTWD.t5,
                tc: govGASTWD.tc,
                tcd: govGASTWD.tcd,
                td: govGASTWD.td,
                tf: govGASTWD.tf,
                tmax: govGASTWD.tmax,
                tmin: govGASTWD.tmin,
                tr: govGASTWD.tr,
                trate: govGASTWD.trate,
                tt: govGASTWD.tt
            });
        });
    }

    updateGovGASTWD = (e) => {
        e.preventDefault();
        let govGASTWD = {
            govGASTWDId: this.state.id,
            a: this.state.a,
            af1: this.state.af1,
            af2: this.state.af2,
            b: this.state.b,
            bf1: this.state.bf1,
            bf2: this.state.bf2,
            c: this.state.c,
            cf2: this.state.cf2,
            ecr: this.state.ecr,
            etd: this.state.etd,
            k3: this.state.k3,
            k4: this.state.k4,
            k5: this.state.k5,
            k6: this.state.k6,
            kd: this.state.kd,
            kdroop: this.state.kdroop,
            kf: this.state.kf,
            ki: this.state.ki,
            kp: this.state.kp,
            mwbase: this.state.mwbase,
            t: this.state.t,
            t3: this.state.t3,
            t4: this.state.t4,
            t5: this.state.t5,
            tc: this.state.tc,
            tcd: this.state.tcd,
            td: this.state.td,
            tf: this.state.tf,
            tmax: this.state.tmax,
            tmin: this.state.tmin,
            tr: this.state.tr,
            trate: this.state.trate,
            tt: this.state.tt
        };
        console.log('govGASTWD => ' + JSON.stringify(govGASTWD));
        console.log('id => ' + JSON.stringify(this.state.id));
        GovGASTWDService.updateGovGASTWD(govGASTWD).then( res => {
            this.props.history.push('/govGASTWDs');
        });
    }

    changeaHandler= (event) => {
        this.setState({a: event.target.value});
    }
    changeaf1Handler= (event) => {
        this.setState({af1: event.target.value});
    }
    changeaf2Handler= (event) => {
        this.setState({af2: event.target.value});
    }
    changebHandler= (event) => {
        this.setState({b: event.target.value});
    }
    changebf1Handler= (event) => {
        this.setState({bf1: event.target.value});
    }
    changebf2Handler= (event) => {
        this.setState({bf2: event.target.value});
    }
    changecHandler= (event) => {
        this.setState({c: event.target.value});
    }
    changecf2Handler= (event) => {
        this.setState({cf2: event.target.value});
    }
    changeecrHandler= (event) => {
        this.setState({ecr: event.target.value});
    }
    changeetdHandler= (event) => {
        this.setState({etd: event.target.value});
    }
    changek3Handler= (event) => {
        this.setState({k3: event.target.value});
    }
    changek4Handler= (event) => {
        this.setState({k4: event.target.value});
    }
    changek5Handler= (event) => {
        this.setState({k5: event.target.value});
    }
    changek6Handler= (event) => {
        this.setState({k6: event.target.value});
    }
    changekdHandler= (event) => {
        this.setState({kd: event.target.value});
    }
    changekdroopHandler= (event) => {
        this.setState({kdroop: event.target.value});
    }
    changekfHandler= (event) => {
        this.setState({kf: event.target.value});
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
    changetHandler= (event) => {
        this.setState({t: event.target.value});
    }
    changet3Handler= (event) => {
        this.setState({t3: event.target.value});
    }
    changet4Handler= (event) => {
        this.setState({t4: event.target.value});
    }
    changet5Handler= (event) => {
        this.setState({t5: event.target.value});
    }
    changetcHandler= (event) => {
        this.setState({tc: event.target.value});
    }
    changetcdHandler= (event) => {
        this.setState({tcd: event.target.value});
    }
    changetdHandler= (event) => {
        this.setState({td: event.target.value});
    }
    changetfHandler= (event) => {
        this.setState({tf: event.target.value});
    }
    changetmaxHandler= (event) => {
        this.setState({tmax: event.target.value});
    }
    changetminHandler= (event) => {
        this.setState({tmin: event.target.value});
    }
    changetrHandler= (event) => {
        this.setState({tr: event.target.value});
    }
    changetrateHandler= (event) => {
        this.setState({trate: event.target.value});
    }
    changettHandler= (event) => {
        this.setState({tt: event.target.value});
    }

    cancel(){
        this.props.history.push('/govGASTWDs');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update GovGASTWD</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                            <label> a: </label>
                                            #formFields( $attribute, 'update')
                                            <label> af1: </label>
                                            #formFields( $attribute, 'update')
                                            <label> af2: </label>
                                            #formFields( $attribute, 'update')
                                            <label> b: </label>
                                            #formFields( $attribute, 'update')
                                            <label> bf1: </label>
                                            #formFields( $attribute, 'update')
                                            <label> bf2: </label>
                                            #formFields( $attribute, 'update')
                                            <label> c: </label>
                                            #formFields( $attribute, 'update')
                                            <label> cf2: </label>
                                            #formFields( $attribute, 'update')
                                            <label> ecr: </label>
                                            #formFields( $attribute, 'update')
                                            <label> etd: </label>
                                            #formFields( $attribute, 'update')
                                            <label> k3: </label>
                                            #formFields( $attribute, 'update')
                                            <label> k4: </label>
                                            #formFields( $attribute, 'update')
                                            <label> k5: </label>
                                            #formFields( $attribute, 'update')
                                            <label> k6: </label>
                                            #formFields( $attribute, 'update')
                                            <label> kd: </label>
                                            #formFields( $attribute, 'update')
                                            <label> kdroop: </label>
                                            #formFields( $attribute, 'update')
                                            <label> kf: </label>
                                            #formFields( $attribute, 'update')
                                            <label> ki: </label>
                                            #formFields( $attribute, 'update')
                                            <label> kp: </label>
                                            #formFields( $attribute, 'update')
                                            <label> mwbase: </label>
                                            #formFields( $attribute, 'update')
                                            <label> t: </label>
                                            #formFields( $attribute, 'update')
                                            <label> t3: </label>
                                            #formFields( $attribute, 'update')
                                            <label> t4: </label>
                                            #formFields( $attribute, 'update')
                                            <label> t5: </label>
                                            #formFields( $attribute, 'update')
                                            <label> tc: </label>
                                            #formFields( $attribute, 'update')
                                            <label> tcd: </label>
                                            #formFields( $attribute, 'update')
                                            <label> td: </label>
                                            #formFields( $attribute, 'update')
                                            <label> tf: </label>
                                            #formFields( $attribute, 'update')
                                            <label> tmax: </label>
                                            #formFields( $attribute, 'update')
                                            <label> tmin: </label>
                                            #formFields( $attribute, 'update')
                                            <label> tr: </label>
                                            #formFields( $attribute, 'update')
                                            <label> trate: </label>
                                            #formFields( $attribute, 'update')
                                            <label> tt: </label>
                                            #formFields( $attribute, 'update')
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateGovGASTWD}>Save</button>
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

export default UpdateGovGASTWDComponent
