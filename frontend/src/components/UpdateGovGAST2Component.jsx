import React, { Component } from 'react'
import GovGAST2Service from '../services/GovGAST2Service';

class UpdateGovGAST2Component extends Component {
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
                kf: '',
                mwbase: '',
                t: '',
                t3: '',
                t4: '',
                t5: '',
                tc: '',
                tcd: '',
                tf: '',
                tmax: '',
                tmin: '',
                tr: '',
                trate: '',
                tt: '',
                w: '',
                x: '',
                y: '',
                z: ''
        }
        this.updateGovGAST2 = this.updateGovGAST2.bind(this);

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
        this.changekfHandler = this.changekfHandler.bind(this);
        this.changemwbaseHandler = this.changemwbaseHandler.bind(this);
        this.changetHandler = this.changetHandler.bind(this);
        this.changet3Handler = this.changet3Handler.bind(this);
        this.changet4Handler = this.changet4Handler.bind(this);
        this.changet5Handler = this.changet5Handler.bind(this);
        this.changetcHandler = this.changetcHandler.bind(this);
        this.changetcdHandler = this.changetcdHandler.bind(this);
        this.changetfHandler = this.changetfHandler.bind(this);
        this.changetmaxHandler = this.changetmaxHandler.bind(this);
        this.changetminHandler = this.changetminHandler.bind(this);
        this.changetrHandler = this.changetrHandler.bind(this);
        this.changetrateHandler = this.changetrateHandler.bind(this);
        this.changettHandler = this.changettHandler.bind(this);
        this.changewHandler = this.changewHandler.bind(this);
        this.changexHandler = this.changexHandler.bind(this);
        this.changeyHandler = this.changeyHandler.bind(this);
        this.changezHandler = this.changezHandler.bind(this);
    }

    componentDidMount(){
        GovGAST2Service.getGovGAST2ById(this.state.id).then( (res) =>{
            let govGAST2 = res.data;
            this.setState({
                a: govGAST2.a,
                af1: govGAST2.af1,
                af2: govGAST2.af2,
                b: govGAST2.b,
                bf1: govGAST2.bf1,
                bf2: govGAST2.bf2,
                c: govGAST2.c,
                cf2: govGAST2.cf2,
                ecr: govGAST2.ecr,
                etd: govGAST2.etd,
                k3: govGAST2.k3,
                k4: govGAST2.k4,
                k5: govGAST2.k5,
                k6: govGAST2.k6,
                kf: govGAST2.kf,
                mwbase: govGAST2.mwbase,
                t: govGAST2.t,
                t3: govGAST2.t3,
                t4: govGAST2.t4,
                t5: govGAST2.t5,
                tc: govGAST2.tc,
                tcd: govGAST2.tcd,
                tf: govGAST2.tf,
                tmax: govGAST2.tmax,
                tmin: govGAST2.tmin,
                tr: govGAST2.tr,
                trate: govGAST2.trate,
                tt: govGAST2.tt,
                w: govGAST2.w,
                x: govGAST2.x,
                y: govGAST2.y,
                z: govGAST2.z
            });
        });
    }

    updateGovGAST2 = (e) => {
        e.preventDefault();
        let govGAST2 = {
            govGAST2Id: this.state.id,
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
            kf: this.state.kf,
            mwbase: this.state.mwbase,
            t: this.state.t,
            t3: this.state.t3,
            t4: this.state.t4,
            t5: this.state.t5,
            tc: this.state.tc,
            tcd: this.state.tcd,
            tf: this.state.tf,
            tmax: this.state.tmax,
            tmin: this.state.tmin,
            tr: this.state.tr,
            trate: this.state.trate,
            tt: this.state.tt,
            w: this.state.w,
            x: this.state.x,
            y: this.state.y,
            z: this.state.z
        };
        console.log('govGAST2 => ' + JSON.stringify(govGAST2));
        console.log('id => ' + JSON.stringify(this.state.id));
        GovGAST2Service.updateGovGAST2(govGAST2).then( res => {
            this.props.history.push('/govGAST2s');
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
    changekfHandler= (event) => {
        this.setState({kf: event.target.value});
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
    changewHandler= (event) => {
        this.setState({w: event.target.value});
    }
    changexHandler= (event) => {
        this.setState({x: event.target.value});
    }
    changeyHandler= (event) => {
        this.setState({y: event.target.value});
    }
    changezHandler= (event) => {
        this.setState({z: event.target.value});
    }

    cancel(){
        this.props.history.push('/govGAST2s');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update GovGAST2</h3>
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
                                            <label> kf: </label>
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
                                            <label> w: </label>
                                            #formFields( $attribute, 'update')
                                            <label> x: </label>
                                            #formFields( $attribute, 'update')
                                            <label> y: </label>
                                            #formFields( $attribute, 'update')
                                            <label> z: </label>
                                            #formFields( $attribute, 'update')
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateGovGAST2}>Save</button>
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

export default UpdateGovGAST2Component
