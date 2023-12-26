import React, { Component } from 'react'
import GovHydro4Service from '../services/GovHydro4Service';

class UpdateGovHydro4Component extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
                at: '',
                bgv0: '',
                bgv1: '',
                bgv2: '',
                bgv3: '',
                bgv4: '',
                bgv5: '',
                bmax: '',
                db1: '',
                db2: '',
                dturb: '',
                eps: '',
                gmax: '',
                gmin: '',
                gv0: '',
                gv1: '',
                gv2: '',
                gv3: '',
                gv4: '',
                gv5: '',
                hdam: '',
                mwbase: '',
                pgv0: '',
                pgv1: '',
                pgv2: '',
                pgv3: '',
                pgv4: '',
                pgv5: '',
                qn1: '',
                rperm: '',
                rtemp: '',
                tblade: '',
                tg: '',
                tp: '',
                tr: '',
                tw: '',
                uc: '',
                uo: ''
        }
        this.updateGovHydro4 = this.updateGovHydro4.bind(this);

        this.changeatHandler = this.changeatHandler.bind(this);
        this.changebgv0Handler = this.changebgv0Handler.bind(this);
        this.changebgv1Handler = this.changebgv1Handler.bind(this);
        this.changebgv2Handler = this.changebgv2Handler.bind(this);
        this.changebgv3Handler = this.changebgv3Handler.bind(this);
        this.changebgv4Handler = this.changebgv4Handler.bind(this);
        this.changebgv5Handler = this.changebgv5Handler.bind(this);
        this.changebmaxHandler = this.changebmaxHandler.bind(this);
        this.changedb1Handler = this.changedb1Handler.bind(this);
        this.changedb2Handler = this.changedb2Handler.bind(this);
        this.changedturbHandler = this.changedturbHandler.bind(this);
        this.changeepsHandler = this.changeepsHandler.bind(this);
        this.changegmaxHandler = this.changegmaxHandler.bind(this);
        this.changegminHandler = this.changegminHandler.bind(this);
        this.changegv0Handler = this.changegv0Handler.bind(this);
        this.changegv1Handler = this.changegv1Handler.bind(this);
        this.changegv2Handler = this.changegv2Handler.bind(this);
        this.changegv3Handler = this.changegv3Handler.bind(this);
        this.changegv4Handler = this.changegv4Handler.bind(this);
        this.changegv5Handler = this.changegv5Handler.bind(this);
        this.changehdamHandler = this.changehdamHandler.bind(this);
        this.changemwbaseHandler = this.changemwbaseHandler.bind(this);
        this.changepgv0Handler = this.changepgv0Handler.bind(this);
        this.changepgv1Handler = this.changepgv1Handler.bind(this);
        this.changepgv2Handler = this.changepgv2Handler.bind(this);
        this.changepgv3Handler = this.changepgv3Handler.bind(this);
        this.changepgv4Handler = this.changepgv4Handler.bind(this);
        this.changepgv5Handler = this.changepgv5Handler.bind(this);
        this.changeqn1Handler = this.changeqn1Handler.bind(this);
        this.changerpermHandler = this.changerpermHandler.bind(this);
        this.changertempHandler = this.changertempHandler.bind(this);
        this.changetbladeHandler = this.changetbladeHandler.bind(this);
        this.changetgHandler = this.changetgHandler.bind(this);
        this.changetpHandler = this.changetpHandler.bind(this);
        this.changetrHandler = this.changetrHandler.bind(this);
        this.changetwHandler = this.changetwHandler.bind(this);
        this.changeucHandler = this.changeucHandler.bind(this);
        this.changeuoHandler = this.changeuoHandler.bind(this);
    }

    componentDidMount(){
        GovHydro4Service.getGovHydro4ById(this.state.id).then( (res) =>{
            let govHydro4 = res.data;
            this.setState({
                at: govHydro4.at,
                bgv0: govHydro4.bgv0,
                bgv1: govHydro4.bgv1,
                bgv2: govHydro4.bgv2,
                bgv3: govHydro4.bgv3,
                bgv4: govHydro4.bgv4,
                bgv5: govHydro4.bgv5,
                bmax: govHydro4.bmax,
                db1: govHydro4.db1,
                db2: govHydro4.db2,
                dturb: govHydro4.dturb,
                eps: govHydro4.eps,
                gmax: govHydro4.gmax,
                gmin: govHydro4.gmin,
                gv0: govHydro4.gv0,
                gv1: govHydro4.gv1,
                gv2: govHydro4.gv2,
                gv3: govHydro4.gv3,
                gv4: govHydro4.gv4,
                gv5: govHydro4.gv5,
                hdam: govHydro4.hdam,
                mwbase: govHydro4.mwbase,
                pgv0: govHydro4.pgv0,
                pgv1: govHydro4.pgv1,
                pgv2: govHydro4.pgv2,
                pgv3: govHydro4.pgv3,
                pgv4: govHydro4.pgv4,
                pgv5: govHydro4.pgv5,
                qn1: govHydro4.qn1,
                rperm: govHydro4.rperm,
                rtemp: govHydro4.rtemp,
                tblade: govHydro4.tblade,
                tg: govHydro4.tg,
                tp: govHydro4.tp,
                tr: govHydro4.tr,
                tw: govHydro4.tw,
                uc: govHydro4.uc,
                uo: govHydro4.uo
            });
        });
    }

    updateGovHydro4 = (e) => {
        e.preventDefault();
        let govHydro4 = {
            govHydro4Id: this.state.id,
            at: this.state.at,
            bgv0: this.state.bgv0,
            bgv1: this.state.bgv1,
            bgv2: this.state.bgv2,
            bgv3: this.state.bgv3,
            bgv4: this.state.bgv4,
            bgv5: this.state.bgv5,
            bmax: this.state.bmax,
            db1: this.state.db1,
            db2: this.state.db2,
            dturb: this.state.dturb,
            eps: this.state.eps,
            gmax: this.state.gmax,
            gmin: this.state.gmin,
            gv0: this.state.gv0,
            gv1: this.state.gv1,
            gv2: this.state.gv2,
            gv3: this.state.gv3,
            gv4: this.state.gv4,
            gv5: this.state.gv5,
            hdam: this.state.hdam,
            mwbase: this.state.mwbase,
            pgv0: this.state.pgv0,
            pgv1: this.state.pgv1,
            pgv2: this.state.pgv2,
            pgv3: this.state.pgv3,
            pgv4: this.state.pgv4,
            pgv5: this.state.pgv5,
            qn1: this.state.qn1,
            rperm: this.state.rperm,
            rtemp: this.state.rtemp,
            tblade: this.state.tblade,
            tg: this.state.tg,
            tp: this.state.tp,
            tr: this.state.tr,
            tw: this.state.tw,
            uc: this.state.uc,
            uo: this.state.uo
        };
        console.log('govHydro4 => ' + JSON.stringify(govHydro4));
        console.log('id => ' + JSON.stringify(this.state.id));
        GovHydro4Service.updateGovHydro4(govHydro4).then( res => {
            this.props.history.push('/govHydro4s');
        });
    }

    changeatHandler= (event) => {
        this.setState({at: event.target.value});
    }
    changebgv0Handler= (event) => {
        this.setState({bgv0: event.target.value});
    }
    changebgv1Handler= (event) => {
        this.setState({bgv1: event.target.value});
    }
    changebgv2Handler= (event) => {
        this.setState({bgv2: event.target.value});
    }
    changebgv3Handler= (event) => {
        this.setState({bgv3: event.target.value});
    }
    changebgv4Handler= (event) => {
        this.setState({bgv4: event.target.value});
    }
    changebgv5Handler= (event) => {
        this.setState({bgv5: event.target.value});
    }
    changebmaxHandler= (event) => {
        this.setState({bmax: event.target.value});
    }
    changedb1Handler= (event) => {
        this.setState({db1: event.target.value});
    }
    changedb2Handler= (event) => {
        this.setState({db2: event.target.value});
    }
    changedturbHandler= (event) => {
        this.setState({dturb: event.target.value});
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
    changegv0Handler= (event) => {
        this.setState({gv0: event.target.value});
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
    changehdamHandler= (event) => {
        this.setState({hdam: event.target.value});
    }
    changemwbaseHandler= (event) => {
        this.setState({mwbase: event.target.value});
    }
    changepgv0Handler= (event) => {
        this.setState({pgv0: event.target.value});
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
    changeqn1Handler= (event) => {
        this.setState({qn1: event.target.value});
    }
    changerpermHandler= (event) => {
        this.setState({rperm: event.target.value});
    }
    changertempHandler= (event) => {
        this.setState({rtemp: event.target.value});
    }
    changetbladeHandler= (event) => {
        this.setState({tblade: event.target.value});
    }
    changetgHandler= (event) => {
        this.setState({tg: event.target.value});
    }
    changetpHandler= (event) => {
        this.setState({tp: event.target.value});
    }
    changetrHandler= (event) => {
        this.setState({tr: event.target.value});
    }
    changetwHandler= (event) => {
        this.setState({tw: event.target.value});
    }
    changeucHandler= (event) => {
        this.setState({uc: event.target.value});
    }
    changeuoHandler= (event) => {
        this.setState({uo: event.target.value});
    }

    cancel(){
        this.props.history.push('/govHydro4s');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update GovHydro4</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                            <label> at: </label>
                                            #formFields( $attribute, 'update')
                                            <label> bgv0: </label>
                                            #formFields( $attribute, 'update')
                                            <label> bgv1: </label>
                                            #formFields( $attribute, 'update')
                                            <label> bgv2: </label>
                                            #formFields( $attribute, 'update')
                                            <label> bgv3: </label>
                                            #formFields( $attribute, 'update')
                                            <label> bgv4: </label>
                                            #formFields( $attribute, 'update')
                                            <label> bgv5: </label>
                                            #formFields( $attribute, 'update')
                                            <label> bmax: </label>
                                            #formFields( $attribute, 'update')
                                            <label> db1: </label>
                                            #formFields( $attribute, 'update')
                                            <label> db2: </label>
                                            #formFields( $attribute, 'update')
                                            <label> dturb: </label>
                                            #formFields( $attribute, 'update')
                                            <label> eps: </label>
                                            #formFields( $attribute, 'update')
                                            <label> gmax: </label>
                                            #formFields( $attribute, 'update')
                                            <label> gmin: </label>
                                            #formFields( $attribute, 'update')
                                            <label> gv0: </label>
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
                                            <label> hdam: </label>
                                            #formFields( $attribute, 'update')
                                            <label> mwbase: </label>
                                            #formFields( $attribute, 'update')
                                            <label> pgv0: </label>
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
                                            <label> qn1: </label>
                                            #formFields( $attribute, 'update')
                                            <label> rperm: </label>
                                            #formFields( $attribute, 'update')
                                            <label> rtemp: </label>
                                            #formFields( $attribute, 'update')
                                            <label> tblade: </label>
                                            #formFields( $attribute, 'update')
                                            <label> tg: </label>
                                            #formFields( $attribute, 'update')
                                            <label> tp: </label>
                                            #formFields( $attribute, 'update')
                                            <label> tr: </label>
                                            #formFields( $attribute, 'update')
                                            <label> tw: </label>
                                            #formFields( $attribute, 'update')
                                            <label> uc: </label>
                                            #formFields( $attribute, 'update')
                                            <label> uo: </label>
                                            #formFields( $attribute, 'update')
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateGovHydro4}>Save</button>
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

export default UpdateGovHydro4Component
