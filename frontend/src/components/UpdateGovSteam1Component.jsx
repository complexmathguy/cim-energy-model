import React, { Component } from 'react'
import GovSteam1Service from '../services/GovSteam1Service';

class UpdateGovSteam1Component extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
                db1: '',
                db2: '',
                eps: '',
                gv1: '',
                gv2: '',
                gv3: '',
                gv4: '',
                gv5: '',
                gv6: '',
                k: '',
                k1: '',
                k2: '',
                k3: '',
                k4: '',
                k5: '',
                k6: '',
                k7: '',
                k8: '',
                mwbase: '',
                pgv1: '',
                pgv2: '',
                pgv3: '',
                pgv4: '',
                pgv5: '',
                pgv6: '',
                pmax: '',
                pmin: '',
                sdb1: '',
                sdb2: '',
                t1: '',
                t2: '',
                t3: '',
                t4: '',
                t5: '',
                t6: '',
                t7: '',
                uc: '',
                uo: '',
                valve: ''
        }
        this.updateGovSteam1 = this.updateGovSteam1.bind(this);

        this.changedb1Handler = this.changedb1Handler.bind(this);
        this.changedb2Handler = this.changedb2Handler.bind(this);
        this.changeepsHandler = this.changeepsHandler.bind(this);
        this.changegv1Handler = this.changegv1Handler.bind(this);
        this.changegv2Handler = this.changegv2Handler.bind(this);
        this.changegv3Handler = this.changegv3Handler.bind(this);
        this.changegv4Handler = this.changegv4Handler.bind(this);
        this.changegv5Handler = this.changegv5Handler.bind(this);
        this.changegv6Handler = this.changegv6Handler.bind(this);
        this.changekHandler = this.changekHandler.bind(this);
        this.changek1Handler = this.changek1Handler.bind(this);
        this.changek2Handler = this.changek2Handler.bind(this);
        this.changek3Handler = this.changek3Handler.bind(this);
        this.changek4Handler = this.changek4Handler.bind(this);
        this.changek5Handler = this.changek5Handler.bind(this);
        this.changek6Handler = this.changek6Handler.bind(this);
        this.changek7Handler = this.changek7Handler.bind(this);
        this.changek8Handler = this.changek8Handler.bind(this);
        this.changemwbaseHandler = this.changemwbaseHandler.bind(this);
        this.changepgv1Handler = this.changepgv1Handler.bind(this);
        this.changepgv2Handler = this.changepgv2Handler.bind(this);
        this.changepgv3Handler = this.changepgv3Handler.bind(this);
        this.changepgv4Handler = this.changepgv4Handler.bind(this);
        this.changepgv5Handler = this.changepgv5Handler.bind(this);
        this.changepgv6Handler = this.changepgv6Handler.bind(this);
        this.changepmaxHandler = this.changepmaxHandler.bind(this);
        this.changepminHandler = this.changepminHandler.bind(this);
        this.changesdb1Handler = this.changesdb1Handler.bind(this);
        this.changesdb2Handler = this.changesdb2Handler.bind(this);
        this.changet1Handler = this.changet1Handler.bind(this);
        this.changet2Handler = this.changet2Handler.bind(this);
        this.changet3Handler = this.changet3Handler.bind(this);
        this.changet4Handler = this.changet4Handler.bind(this);
        this.changet5Handler = this.changet5Handler.bind(this);
        this.changet6Handler = this.changet6Handler.bind(this);
        this.changet7Handler = this.changet7Handler.bind(this);
        this.changeucHandler = this.changeucHandler.bind(this);
        this.changeuoHandler = this.changeuoHandler.bind(this);
        this.changevalveHandler = this.changevalveHandler.bind(this);
    }

    componentDidMount(){
        GovSteam1Service.getGovSteam1ById(this.state.id).then( (res) =>{
            let govSteam1 = res.data;
            this.setState({
                db1: govSteam1.db1,
                db2: govSteam1.db2,
                eps: govSteam1.eps,
                gv1: govSteam1.gv1,
                gv2: govSteam1.gv2,
                gv3: govSteam1.gv3,
                gv4: govSteam1.gv4,
                gv5: govSteam1.gv5,
                gv6: govSteam1.gv6,
                k: govSteam1.k,
                k1: govSteam1.k1,
                k2: govSteam1.k2,
                k3: govSteam1.k3,
                k4: govSteam1.k4,
                k5: govSteam1.k5,
                k6: govSteam1.k6,
                k7: govSteam1.k7,
                k8: govSteam1.k8,
                mwbase: govSteam1.mwbase,
                pgv1: govSteam1.pgv1,
                pgv2: govSteam1.pgv2,
                pgv3: govSteam1.pgv3,
                pgv4: govSteam1.pgv4,
                pgv5: govSteam1.pgv5,
                pgv6: govSteam1.pgv6,
                pmax: govSteam1.pmax,
                pmin: govSteam1.pmin,
                sdb1: govSteam1.sdb1,
                sdb2: govSteam1.sdb2,
                t1: govSteam1.t1,
                t2: govSteam1.t2,
                t3: govSteam1.t3,
                t4: govSteam1.t4,
                t5: govSteam1.t5,
                t6: govSteam1.t6,
                t7: govSteam1.t7,
                uc: govSteam1.uc,
                uo: govSteam1.uo,
                valve: govSteam1.valve
            });
        });
    }

    updateGovSteam1 = (e) => {
        e.preventDefault();
        let govSteam1 = {
            govSteam1Id: this.state.id,
            db1: this.state.db1,
            db2: this.state.db2,
            eps: this.state.eps,
            gv1: this.state.gv1,
            gv2: this.state.gv2,
            gv3: this.state.gv3,
            gv4: this.state.gv4,
            gv5: this.state.gv5,
            gv6: this.state.gv6,
            k: this.state.k,
            k1: this.state.k1,
            k2: this.state.k2,
            k3: this.state.k3,
            k4: this.state.k4,
            k5: this.state.k5,
            k6: this.state.k6,
            k7: this.state.k7,
            k8: this.state.k8,
            mwbase: this.state.mwbase,
            pgv1: this.state.pgv1,
            pgv2: this.state.pgv2,
            pgv3: this.state.pgv3,
            pgv4: this.state.pgv4,
            pgv5: this.state.pgv5,
            pgv6: this.state.pgv6,
            pmax: this.state.pmax,
            pmin: this.state.pmin,
            sdb1: this.state.sdb1,
            sdb2: this.state.sdb2,
            t1: this.state.t1,
            t2: this.state.t2,
            t3: this.state.t3,
            t4: this.state.t4,
            t5: this.state.t5,
            t6: this.state.t6,
            t7: this.state.t7,
            uc: this.state.uc,
            uo: this.state.uo,
            valve: this.state.valve
        };
        console.log('govSteam1 => ' + JSON.stringify(govSteam1));
        console.log('id => ' + JSON.stringify(this.state.id));
        GovSteam1Service.updateGovSteam1(govSteam1).then( res => {
            this.props.history.push('/govSteam1s');
        });
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
    changekHandler= (event) => {
        this.setState({k: event.target.value});
    }
    changek1Handler= (event) => {
        this.setState({k1: event.target.value});
    }
    changek2Handler= (event) => {
        this.setState({k2: event.target.value});
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
    changek7Handler= (event) => {
        this.setState({k7: event.target.value});
    }
    changek8Handler= (event) => {
        this.setState({k8: event.target.value});
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
    changesdb1Handler= (event) => {
        this.setState({sdb1: event.target.value});
    }
    changesdb2Handler= (event) => {
        this.setState({sdb2: event.target.value});
    }
    changet1Handler= (event) => {
        this.setState({t1: event.target.value});
    }
    changet2Handler= (event) => {
        this.setState({t2: event.target.value});
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
    changet6Handler= (event) => {
        this.setState({t6: event.target.value});
    }
    changet7Handler= (event) => {
        this.setState({t7: event.target.value});
    }
    changeucHandler= (event) => {
        this.setState({uc: event.target.value});
    }
    changeuoHandler= (event) => {
        this.setState({uo: event.target.value});
    }
    changevalveHandler= (event) => {
        this.setState({valve: event.target.value});
    }

    cancel(){
        this.props.history.push('/govSteam1s');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update GovSteam1</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                            <label> db1: </label>
                                            #formFields( $attribute, 'update')
                                            <label> db2: </label>
                                            #formFields( $attribute, 'update')
                                            <label> eps: </label>
                                            #formFields( $attribute, 'update')
                                            <label> gv1: </label>
                                            #formFields( $attribute, 'update')
                                            <label> gv2: </label>
                                            #formFields( $attribute, 'update')
                                            <label> gv3: </label>
                                            #formFields( $attribute, 'update')
                                            <label> gv4: </label>
                                            #formFields( $attribute, 'update')
                                            <label> gv5: </label>
                                            #formFields( $attribute, 'update')
                                            <label> gv6: </label>
                                            #formFields( $attribute, 'update')
                                            <label> k: </label>
                                            #formFields( $attribute, 'update')
                                            <label> k1: </label>
                                            #formFields( $attribute, 'update')
                                            <label> k2: </label>
                                            #formFields( $attribute, 'update')
                                            <label> k3: </label>
                                            #formFields( $attribute, 'update')
                                            <label> k4: </label>
                                            #formFields( $attribute, 'update')
                                            <label> k5: </label>
                                            #formFields( $attribute, 'update')
                                            <label> k6: </label>
                                            #formFields( $attribute, 'update')
                                            <label> k7: </label>
                                            #formFields( $attribute, 'update')
                                            <label> k8: </label>
                                            #formFields( $attribute, 'update')
                                            <label> mwbase: </label>
                                            #formFields( $attribute, 'update')
                                            <label> pgv1: </label>
                                            #formFields( $attribute, 'update')
                                            <label> pgv2: </label>
                                            #formFields( $attribute, 'update')
                                            <label> pgv3: </label>
                                            #formFields( $attribute, 'update')
                                            <label> pgv4: </label>
                                            #formFields( $attribute, 'update')
                                            <label> pgv5: </label>
                                            #formFields( $attribute, 'update')
                                            <label> pgv6: </label>
                                            #formFields( $attribute, 'update')
                                            <label> pmax: </label>
                                            #formFields( $attribute, 'update')
                                            <label> pmin: </label>
                                            #formFields( $attribute, 'update')
                                            <label> sdb1: </label>
                                            #formFields( $attribute, 'update')
                                            <label> sdb2: </label>
                                            #formFields( $attribute, 'update')
                                            <label> t1: </label>
                                            #formFields( $attribute, 'update')
                                            <label> t2: </label>
                                            #formFields( $attribute, 'update')
                                            <label> t3: </label>
                                            #formFields( $attribute, 'update')
                                            <label> t4: </label>
                                            #formFields( $attribute, 'update')
                                            <label> t5: </label>
                                            #formFields( $attribute, 'update')
                                            <label> t6: </label>
                                            #formFields( $attribute, 'update')
                                            <label> t7: </label>
                                            #formFields( $attribute, 'update')
                                            <label> uc: </label>
                                            #formFields( $attribute, 'update')
                                            <label> uo: </label>
                                            #formFields( $attribute, 'update')
                                            <label> valve: </label>
                                            #formFields( $attribute, 'update')
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateGovSteam1}>Save</button>
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

export default UpdateGovSteam1Component
