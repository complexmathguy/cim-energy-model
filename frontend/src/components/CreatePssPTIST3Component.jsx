import React, { Component } from 'react'
import PssPTIST3Service from '../services/PssPTIST3Service';

class CreatePssPTIST3Component extends Component {
    constructor(props) {
        super(props)

        this.state = {
            // step 2
            id: this.props.match.params.id,
                a0: '',
                a1: '',
                a2: '',
                a3: '',
                a4: '',
                a5: '',
                al: '',
                athres: '',
                b0: '',
                b1: '',
                b2: '',
                b3: '',
                b4: '',
                b5: '',
                dl: '',
                dtc: '',
                dtf: '',
                dtp: '',
                isw: '',
                k: '',
                lthres: '',
                m: '',
                nav: '',
                ncl: '',
                ncr: '',
                pmin: '',
                t1: '',
                t2: '',
                t3: '',
                t4: '',
                t5: '',
                t6: '',
                tf: '',
                tp: ''
        }
        this.changea0Handler = this.changea0Handler.bind(this);
        this.changea1Handler = this.changea1Handler.bind(this);
        this.changea2Handler = this.changea2Handler.bind(this);
        this.changea3Handler = this.changea3Handler.bind(this);
        this.changea4Handler = this.changea4Handler.bind(this);
        this.changea5Handler = this.changea5Handler.bind(this);
        this.changealHandler = this.changealHandler.bind(this);
        this.changeathresHandler = this.changeathresHandler.bind(this);
        this.changeb0Handler = this.changeb0Handler.bind(this);
        this.changeb1Handler = this.changeb1Handler.bind(this);
        this.changeb2Handler = this.changeb2Handler.bind(this);
        this.changeb3Handler = this.changeb3Handler.bind(this);
        this.changeb4Handler = this.changeb4Handler.bind(this);
        this.changeb5Handler = this.changeb5Handler.bind(this);
        this.changedlHandler = this.changedlHandler.bind(this);
        this.changedtcHandler = this.changedtcHandler.bind(this);
        this.changedtfHandler = this.changedtfHandler.bind(this);
        this.changedtpHandler = this.changedtpHandler.bind(this);
        this.changeiswHandler = this.changeiswHandler.bind(this);
        this.changekHandler = this.changekHandler.bind(this);
        this.changelthresHandler = this.changelthresHandler.bind(this);
        this.changemHandler = this.changemHandler.bind(this);
        this.changenavHandler = this.changenavHandler.bind(this);
        this.changenclHandler = this.changenclHandler.bind(this);
        this.changencrHandler = this.changencrHandler.bind(this);
        this.changepminHandler = this.changepminHandler.bind(this);
        this.changet1Handler = this.changet1Handler.bind(this);
        this.changet2Handler = this.changet2Handler.bind(this);
        this.changet3Handler = this.changet3Handler.bind(this);
        this.changet4Handler = this.changet4Handler.bind(this);
        this.changet5Handler = this.changet5Handler.bind(this);
        this.changet6Handler = this.changet6Handler.bind(this);
        this.changetfHandler = this.changetfHandler.bind(this);
        this.changetpHandler = this.changetpHandler.bind(this);
    }

    // step 3
    componentDidMount(){

        // step 4
        if(this.state.id === '_add'){
            return
        }else{
            PssPTIST3Service.getPssPTIST3ById(this.state.id).then( (res) =>{
                let pssPTIST3 = res.data;
                this.setState({
                    a0: pssPTIST3.a0,
                    a1: pssPTIST3.a1,
                    a2: pssPTIST3.a2,
                    a3: pssPTIST3.a3,
                    a4: pssPTIST3.a4,
                    a5: pssPTIST3.a5,
                    al: pssPTIST3.al,
                    athres: pssPTIST3.athres,
                    b0: pssPTIST3.b0,
                    b1: pssPTIST3.b1,
                    b2: pssPTIST3.b2,
                    b3: pssPTIST3.b3,
                    b4: pssPTIST3.b4,
                    b5: pssPTIST3.b5,
                    dl: pssPTIST3.dl,
                    dtc: pssPTIST3.dtc,
                    dtf: pssPTIST3.dtf,
                    dtp: pssPTIST3.dtp,
                    isw: pssPTIST3.isw,
                    k: pssPTIST3.k,
                    lthres: pssPTIST3.lthres,
                    m: pssPTIST3.m,
                    nav: pssPTIST3.nav,
                    ncl: pssPTIST3.ncl,
                    ncr: pssPTIST3.ncr,
                    pmin: pssPTIST3.pmin,
                    t1: pssPTIST3.t1,
                    t2: pssPTIST3.t2,
                    t3: pssPTIST3.t3,
                    t4: pssPTIST3.t4,
                    t5: pssPTIST3.t5,
                    t6: pssPTIST3.t6,
                    tf: pssPTIST3.tf,
                    tp: pssPTIST3.tp
                });
            });
        }        
    }
    saveOrUpdatePssPTIST3 = (e) => {
        e.preventDefault();
        let pssPTIST3 = {
                pssPTIST3Id: this.state.id,
                a0: this.state.a0,
                a1: this.state.a1,
                a2: this.state.a2,
                a3: this.state.a3,
                a4: this.state.a4,
                a5: this.state.a5,
                al: this.state.al,
                athres: this.state.athres,
                b0: this.state.b0,
                b1: this.state.b1,
                b2: this.state.b2,
                b3: this.state.b3,
                b4: this.state.b4,
                b5: this.state.b5,
                dl: this.state.dl,
                dtc: this.state.dtc,
                dtf: this.state.dtf,
                dtp: this.state.dtp,
                isw: this.state.isw,
                k: this.state.k,
                lthres: this.state.lthres,
                m: this.state.m,
                nav: this.state.nav,
                ncl: this.state.ncl,
                ncr: this.state.ncr,
                pmin: this.state.pmin,
                t1: this.state.t1,
                t2: this.state.t2,
                t3: this.state.t3,
                t4: this.state.t4,
                t5: this.state.t5,
                t6: this.state.t6,
                tf: this.state.tf,
                tp: this.state.tp
            };
        console.log('pssPTIST3 => ' + JSON.stringify(pssPTIST3));

        // step 5
        if(this.state.id === '_add'){
            pssPTIST3.pssPTIST3Id=''
            PssPTIST3Service.createPssPTIST3(pssPTIST3).then(res =>{
                this.props.history.push('/pssPTIST3s');
            });
        }else{
            PssPTIST3Service.updatePssPTIST3(pssPTIST3).then( res => {
                this.props.history.push('/pssPTIST3s');
            });
        }
    }
    
    changea0Handler= (event) => {
        this.setState({a0: event.target.value});
    }
    changea1Handler= (event) => {
        this.setState({a1: event.target.value});
    }
    changea2Handler= (event) => {
        this.setState({a2: event.target.value});
    }
    changea3Handler= (event) => {
        this.setState({a3: event.target.value});
    }
    changea4Handler= (event) => {
        this.setState({a4: event.target.value});
    }
    changea5Handler= (event) => {
        this.setState({a5: event.target.value});
    }
    changealHandler= (event) => {
        this.setState({al: event.target.value});
    }
    changeathresHandler= (event) => {
        this.setState({athres: event.target.value});
    }
    changeb0Handler= (event) => {
        this.setState({b0: event.target.value});
    }
    changeb1Handler= (event) => {
        this.setState({b1: event.target.value});
    }
    changeb2Handler= (event) => {
        this.setState({b2: event.target.value});
    }
    changeb3Handler= (event) => {
        this.setState({b3: event.target.value});
    }
    changeb4Handler= (event) => {
        this.setState({b4: event.target.value});
    }
    changeb5Handler= (event) => {
        this.setState({b5: event.target.value});
    }
    changedlHandler= (event) => {
        this.setState({dl: event.target.value});
    }
    changedtcHandler= (event) => {
        this.setState({dtc: event.target.value});
    }
    changedtfHandler= (event) => {
        this.setState({dtf: event.target.value});
    }
    changedtpHandler= (event) => {
        this.setState({dtp: event.target.value});
    }
    changeiswHandler= (event) => {
        this.setState({isw: event.target.value});
    }
    changekHandler= (event) => {
        this.setState({k: event.target.value});
    }
    changelthresHandler= (event) => {
        this.setState({lthres: event.target.value});
    }
    changemHandler= (event) => {
        this.setState({m: event.target.value});
    }
    changenavHandler= (event) => {
        this.setState({nav: event.target.value});
    }
    changenclHandler= (event) => {
        this.setState({ncl: event.target.value});
    }
    changencrHandler= (event) => {
        this.setState({ncr: event.target.value});
    }
    changepminHandler= (event) => {
        this.setState({pmin: event.target.value});
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
    changetfHandler= (event) => {
        this.setState({tf: event.target.value});
    }
    changetpHandler= (event) => {
        this.setState({tp: event.target.value});
    }

    cancel(){
        this.props.history.push('/pssPTIST3s');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add PssPTIST3</h3>
        }else{
            return <h3 className="text-center">Update PssPTIST3</h3>
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
                                            <label> a0: </label>
                                            #formFields( $attribute, 'create')
                                            <label> a1: </label>
                                            #formFields( $attribute, 'create')
                                            <label> a2: </label>
                                            #formFields( $attribute, 'create')
                                            <label> a3: </label>
                                            #formFields( $attribute, 'create')
                                            <label> a4: </label>
                                            #formFields( $attribute, 'create')
                                            <label> a5: </label>
                                            #formFields( $attribute, 'create')
                                            <label> al: </label>
                                            #formFields( $attribute, 'create')
                                            <label> athres: </label>
                                            #formFields( $attribute, 'create')
                                            <label> b0: </label>
                                            #formFields( $attribute, 'create')
                                            <label> b1: </label>
                                            #formFields( $attribute, 'create')
                                            <label> b2: </label>
                                            #formFields( $attribute, 'create')
                                            <label> b3: </label>
                                            #formFields( $attribute, 'create')
                                            <label> b4: </label>
                                            #formFields( $attribute, 'create')
                                            <label> b5: </label>
                                            #formFields( $attribute, 'create')
                                            <label> dl: </label>
                                            #formFields( $attribute, 'create')
                                            <label> dtc: </label>
                                            #formFields( $attribute, 'create')
                                            <label> dtf: </label>
                                            #formFields( $attribute, 'create')
                                            <label> dtp: </label>
                                            #formFields( $attribute, 'create')
                                            <label> isw: </label>
                                            #formFields( $attribute, 'create')
                                            <label> k: </label>
                                            #formFields( $attribute, 'create')
                                            <label> lthres: </label>
                                            #formFields( $attribute, 'create')
                                            <label> m: </label>
                                            #formFields( $attribute, 'create')
                                            <label> nav: </label>
                                            #formFields( $attribute, 'create')
                                            <label> ncl: </label>
                                            #formFields( $attribute, 'create')
                                            <label> ncr: </label>
                                            #formFields( $attribute, 'create')
                                            <label> pmin: </label>
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
                                            <label> t6: </label>
                                            #formFields( $attribute, 'create')
                                            <label> tf: </label>
                                            #formFields( $attribute, 'create')
                                            <label> tp: </label>
                                            #formFields( $attribute, 'create')
                                        </div>

                                        <button className="btn btn-success" onClick={this.saveOrUpdatePssPTIST3}>Save</button>
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

export default CreatePssPTIST3Component
