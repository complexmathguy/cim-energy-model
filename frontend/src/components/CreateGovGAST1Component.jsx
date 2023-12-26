import React, { Component } from 'react'
import GovGAST1Service from '../services/GovGAST1Service';

class CreateGovGAST1Component extends Component {
    constructor(props) {
        super(props)

        this.state = {
            // step 2
            id: this.props.match.params.id,
                a: '',
                b: '',
                db1: '',
                db2: '',
                eps: '',
                fidle: '',
                gv1: '',
                gv2: '',
                gv3: '',
                gv4: '',
                gv5: '',
                gv6: '',
                ka: '',
                kt: '',
                lmax: '',
                loadinc: '',
                ltrate: '',
                mwbase: '',
                pgv1: '',
                pgv2: '',
                pgv3: '',
                pgv4: '',
                pgv5: '',
                pgv6: '',
                r: '',
                rmax: '',
                t1: '',
                t2: '',
                t3: '',
                t4: '',
                t5: '',
                tltr: '',
                vmax: '',
                vmin: ''
        }
        this.changeaHandler = this.changeaHandler.bind(this);
        this.changebHandler = this.changebHandler.bind(this);
        this.changedb1Handler = this.changedb1Handler.bind(this);
        this.changedb2Handler = this.changedb2Handler.bind(this);
        this.changeepsHandler = this.changeepsHandler.bind(this);
        this.changefidleHandler = this.changefidleHandler.bind(this);
        this.changegv1Handler = this.changegv1Handler.bind(this);
        this.changegv2Handler = this.changegv2Handler.bind(this);
        this.changegv3Handler = this.changegv3Handler.bind(this);
        this.changegv4Handler = this.changegv4Handler.bind(this);
        this.changegv5Handler = this.changegv5Handler.bind(this);
        this.changegv6Handler = this.changegv6Handler.bind(this);
        this.changekaHandler = this.changekaHandler.bind(this);
        this.changektHandler = this.changektHandler.bind(this);
        this.changelmaxHandler = this.changelmaxHandler.bind(this);
        this.changeloadincHandler = this.changeloadincHandler.bind(this);
        this.changeltrateHandler = this.changeltrateHandler.bind(this);
        this.changemwbaseHandler = this.changemwbaseHandler.bind(this);
        this.changepgv1Handler = this.changepgv1Handler.bind(this);
        this.changepgv2Handler = this.changepgv2Handler.bind(this);
        this.changepgv3Handler = this.changepgv3Handler.bind(this);
        this.changepgv4Handler = this.changepgv4Handler.bind(this);
        this.changepgv5Handler = this.changepgv5Handler.bind(this);
        this.changepgv6Handler = this.changepgv6Handler.bind(this);
        this.changerHandler = this.changerHandler.bind(this);
        this.changermaxHandler = this.changermaxHandler.bind(this);
        this.changet1Handler = this.changet1Handler.bind(this);
        this.changet2Handler = this.changet2Handler.bind(this);
        this.changet3Handler = this.changet3Handler.bind(this);
        this.changet4Handler = this.changet4Handler.bind(this);
        this.changet5Handler = this.changet5Handler.bind(this);
        this.changetltrHandler = this.changetltrHandler.bind(this);
        this.changevmaxHandler = this.changevmaxHandler.bind(this);
        this.changevminHandler = this.changevminHandler.bind(this);
    }

    // step 3
    componentDidMount(){

        // step 4
        if(this.state.id === '_add'){
            return
        }else{
            GovGAST1Service.getGovGAST1ById(this.state.id).then( (res) =>{
                let govGAST1 = res.data;
                this.setState({
                    a: govGAST1.a,
                    b: govGAST1.b,
                    db1: govGAST1.db1,
                    db2: govGAST1.db2,
                    eps: govGAST1.eps,
                    fidle: govGAST1.fidle,
                    gv1: govGAST1.gv1,
                    gv2: govGAST1.gv2,
                    gv3: govGAST1.gv3,
                    gv4: govGAST1.gv4,
                    gv5: govGAST1.gv5,
                    gv6: govGAST1.gv6,
                    ka: govGAST1.ka,
                    kt: govGAST1.kt,
                    lmax: govGAST1.lmax,
                    loadinc: govGAST1.loadinc,
                    ltrate: govGAST1.ltrate,
                    mwbase: govGAST1.mwbase,
                    pgv1: govGAST1.pgv1,
                    pgv2: govGAST1.pgv2,
                    pgv3: govGAST1.pgv3,
                    pgv4: govGAST1.pgv4,
                    pgv5: govGAST1.pgv5,
                    pgv6: govGAST1.pgv6,
                    r: govGAST1.r,
                    rmax: govGAST1.rmax,
                    t1: govGAST1.t1,
                    t2: govGAST1.t2,
                    t3: govGAST1.t3,
                    t4: govGAST1.t4,
                    t5: govGAST1.t5,
                    tltr: govGAST1.tltr,
                    vmax: govGAST1.vmax,
                    vmin: govGAST1.vmin
                });
            });
        }        
    }
    saveOrUpdateGovGAST1 = (e) => {
        e.preventDefault();
        let govGAST1 = {
                govGAST1Id: this.state.id,
                a: this.state.a,
                b: this.state.b,
                db1: this.state.db1,
                db2: this.state.db2,
                eps: this.state.eps,
                fidle: this.state.fidle,
                gv1: this.state.gv1,
                gv2: this.state.gv2,
                gv3: this.state.gv3,
                gv4: this.state.gv4,
                gv5: this.state.gv5,
                gv6: this.state.gv6,
                ka: this.state.ka,
                kt: this.state.kt,
                lmax: this.state.lmax,
                loadinc: this.state.loadinc,
                ltrate: this.state.ltrate,
                mwbase: this.state.mwbase,
                pgv1: this.state.pgv1,
                pgv2: this.state.pgv2,
                pgv3: this.state.pgv3,
                pgv4: this.state.pgv4,
                pgv5: this.state.pgv5,
                pgv6: this.state.pgv6,
                r: this.state.r,
                rmax: this.state.rmax,
                t1: this.state.t1,
                t2: this.state.t2,
                t3: this.state.t3,
                t4: this.state.t4,
                t5: this.state.t5,
                tltr: this.state.tltr,
                vmax: this.state.vmax,
                vmin: this.state.vmin
            };
        console.log('govGAST1 => ' + JSON.stringify(govGAST1));

        // step 5
        if(this.state.id === '_add'){
            govGAST1.govGAST1Id=''
            GovGAST1Service.createGovGAST1(govGAST1).then(res =>{
                this.props.history.push('/govGAST1s');
            });
        }else{
            GovGAST1Service.updateGovGAST1(govGAST1).then( res => {
                this.props.history.push('/govGAST1s');
            });
        }
    }
    
    changeaHandler= (event) => {
        this.setState({a: event.target.value});
    }
    changebHandler= (event) => {
        this.setState({b: event.target.value});
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
    changefidleHandler= (event) => {
        this.setState({fidle: event.target.value});
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
    changekaHandler= (event) => {
        this.setState({ka: event.target.value});
    }
    changektHandler= (event) => {
        this.setState({kt: event.target.value});
    }
    changelmaxHandler= (event) => {
        this.setState({lmax: event.target.value});
    }
    changeloadincHandler= (event) => {
        this.setState({loadinc: event.target.value});
    }
    changeltrateHandler= (event) => {
        this.setState({ltrate: event.target.value});
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
    changerHandler= (event) => {
        this.setState({r: event.target.value});
    }
    changermaxHandler= (event) => {
        this.setState({rmax: event.target.value});
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
    changetltrHandler= (event) => {
        this.setState({tltr: event.target.value});
    }
    changevmaxHandler= (event) => {
        this.setState({vmax: event.target.value});
    }
    changevminHandler= (event) => {
        this.setState({vmin: event.target.value});
    }

    cancel(){
        this.props.history.push('/govGAST1s');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add GovGAST1</h3>
        }else{
            return <h3 className="text-center">Update GovGAST1</h3>
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
                                            <label> a: </label>
                                            #formFields( $attribute, 'create')
                                            <label> b: </label>
                                            #formFields( $attribute, 'create')
                                            <label> db1: </label>
                                            #formFields( $attribute, 'create')
                                            <label> db2: </label>
                                            #formFields( $attribute, 'create')
                                            <label> eps: </label>
                                            #formFields( $attribute, 'create')
                                            <label> fidle: </label>
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
                                            <label> ka: </label>
                                            #formFields( $attribute, 'create')
                                            <label> kt: </label>
                                            #formFields( $attribute, 'create')
                                            <label> lmax: </label>
                                            #formFields( $attribute, 'create')
                                            <label> loadinc: </label>
                                            #formFields( $attribute, 'create')
                                            <label> ltrate: </label>
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
                                            <label> r: </label>
                                            #formFields( $attribute, 'create')
                                            <label> rmax: </label>
                                            #formFields( $attribute, 'create')
                                            <label> t1: </label>
                                            #formFields( $attribute, 'create')
                                            <label> t2: </label>
                                            #formFields( $attribute, 'create')
                                            <label> t3: </label>
                                            #formFields( $attribute, 'create')
                                            <label> t4: </label>
                                            #formFields( $attribute, 'create')
                                            <label> t5: </label>
                                            #formFields( $attribute, 'create')
                                            <label> tltr: </label>
                                            #formFields( $attribute, 'create')
                                            <label> vmax: </label>
                                            #formFields( $attribute, 'create')
                                            <label> vmin: </label>
                                            #formFields( $attribute, 'create')
                                        </div>

                                        <button className="btn btn-success" onClick={this.saveOrUpdateGovGAST1}>Save</button>
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

export default CreateGovGAST1Component
