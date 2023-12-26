import React, { Component } from 'react'
import GovHydroIEEE2Service from '../services/GovHydroIEEE2Service';

class CreateGovHydroIEEE2Component extends Component {
    constructor(props) {
        super(props)

        this.state = {
            // step 2
            id: this.props.match.params.id,
                aturb: '',
                bturb: '',
                gv1: '',
                gv2: '',
                gv3: '',
                gv4: '',
                gv5: '',
                gv6: '',
                kturb: '',
                mwbase: '',
                pgv1: '',
                pgv2: '',
                pgv3: '',
                pgv4: '',
                pgv5: '',
                pgv6: '',
                pmax: '',
                pmin: '',
                rperm: '',
                rtemp: '',
                tg: '',
                tp: '',
                tr: '',
                tw: '',
                uc: '',
                uo: ''
        }
        this.changeaturbHandler = this.changeaturbHandler.bind(this);
        this.changebturbHandler = this.changebturbHandler.bind(this);
        this.changegv1Handler = this.changegv1Handler.bind(this);
        this.changegv2Handler = this.changegv2Handler.bind(this);
        this.changegv3Handler = this.changegv3Handler.bind(this);
        this.changegv4Handler = this.changegv4Handler.bind(this);
        this.changegv5Handler = this.changegv5Handler.bind(this);
        this.changegv6Handler = this.changegv6Handler.bind(this);
        this.changekturbHandler = this.changekturbHandler.bind(this);
        this.changemwbaseHandler = this.changemwbaseHandler.bind(this);
        this.changepgv1Handler = this.changepgv1Handler.bind(this);
        this.changepgv2Handler = this.changepgv2Handler.bind(this);
        this.changepgv3Handler = this.changepgv3Handler.bind(this);
        this.changepgv4Handler = this.changepgv4Handler.bind(this);
        this.changepgv5Handler = this.changepgv5Handler.bind(this);
        this.changepgv6Handler = this.changepgv6Handler.bind(this);
        this.changepmaxHandler = this.changepmaxHandler.bind(this);
        this.changepminHandler = this.changepminHandler.bind(this);
        this.changerpermHandler = this.changerpermHandler.bind(this);
        this.changertempHandler = this.changertempHandler.bind(this);
        this.changetgHandler = this.changetgHandler.bind(this);
        this.changetpHandler = this.changetpHandler.bind(this);
        this.changetrHandler = this.changetrHandler.bind(this);
        this.changetwHandler = this.changetwHandler.bind(this);
        this.changeucHandler = this.changeucHandler.bind(this);
        this.changeuoHandler = this.changeuoHandler.bind(this);
    }

    // step 3
    componentDidMount(){

        // step 4
        if(this.state.id === '_add'){
            return
        }else{
            GovHydroIEEE2Service.getGovHydroIEEE2ById(this.state.id).then( (res) =>{
                let govHydroIEEE2 = res.data;
                this.setState({
                    aturb: govHydroIEEE2.aturb,
                    bturb: govHydroIEEE2.bturb,
                    gv1: govHydroIEEE2.gv1,
                    gv2: govHydroIEEE2.gv2,
                    gv3: govHydroIEEE2.gv3,
                    gv4: govHydroIEEE2.gv4,
                    gv5: govHydroIEEE2.gv5,
                    gv6: govHydroIEEE2.gv6,
                    kturb: govHydroIEEE2.kturb,
                    mwbase: govHydroIEEE2.mwbase,
                    pgv1: govHydroIEEE2.pgv1,
                    pgv2: govHydroIEEE2.pgv2,
                    pgv3: govHydroIEEE2.pgv3,
                    pgv4: govHydroIEEE2.pgv4,
                    pgv5: govHydroIEEE2.pgv5,
                    pgv6: govHydroIEEE2.pgv6,
                    pmax: govHydroIEEE2.pmax,
                    pmin: govHydroIEEE2.pmin,
                    rperm: govHydroIEEE2.rperm,
                    rtemp: govHydroIEEE2.rtemp,
                    tg: govHydroIEEE2.tg,
                    tp: govHydroIEEE2.tp,
                    tr: govHydroIEEE2.tr,
                    tw: govHydroIEEE2.tw,
                    uc: govHydroIEEE2.uc,
                    uo: govHydroIEEE2.uo
                });
            });
        }        
    }
    saveOrUpdateGovHydroIEEE2 = (e) => {
        e.preventDefault();
        let govHydroIEEE2 = {
                govHydroIEEE2Id: this.state.id,
                aturb: this.state.aturb,
                bturb: this.state.bturb,
                gv1: this.state.gv1,
                gv2: this.state.gv2,
                gv3: this.state.gv3,
                gv4: this.state.gv4,
                gv5: this.state.gv5,
                gv6: this.state.gv6,
                kturb: this.state.kturb,
                mwbase: this.state.mwbase,
                pgv1: this.state.pgv1,
                pgv2: this.state.pgv2,
                pgv3: this.state.pgv3,
                pgv4: this.state.pgv4,
                pgv5: this.state.pgv5,
                pgv6: this.state.pgv6,
                pmax: this.state.pmax,
                pmin: this.state.pmin,
                rperm: this.state.rperm,
                rtemp: this.state.rtemp,
                tg: this.state.tg,
                tp: this.state.tp,
                tr: this.state.tr,
                tw: this.state.tw,
                uc: this.state.uc,
                uo: this.state.uo
            };
        console.log('govHydroIEEE2 => ' + JSON.stringify(govHydroIEEE2));

        // step 5
        if(this.state.id === '_add'){
            govHydroIEEE2.govHydroIEEE2Id=''
            GovHydroIEEE2Service.createGovHydroIEEE2(govHydroIEEE2).then(res =>{
                this.props.history.push('/govHydroIEEE2s');
            });
        }else{
            GovHydroIEEE2Service.updateGovHydroIEEE2(govHydroIEEE2).then( res => {
                this.props.history.push('/govHydroIEEE2s');
            });
        }
    }
    
    changeaturbHandler= (event) => {
        this.setState({aturb: event.target.value});
    }
    changebturbHandler= (event) => {
        this.setState({bturb: event.target.value});
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
    changekturbHandler= (event) => {
        this.setState({kturb: event.target.value});
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
    changerpermHandler= (event) => {
        this.setState({rperm: event.target.value});
    }
    changertempHandler= (event) => {
        this.setState({rtemp: event.target.value});
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
        this.props.history.push('/govHydroIEEE2s');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add GovHydroIEEE2</h3>
        }else{
            return <h3 className="text-center">Update GovHydroIEEE2</h3>
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
                                            <label> kturb: </label>
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
                                            <label> rperm: </label>
                                            #formFields( $attribute, 'create')
                                            <label> rtemp: </label>
                                            #formFields( $attribute, 'create')
                                            <label> tg: </label>
                                            #formFields( $attribute, 'create')
                                            <label> tp: </label>
                                            #formFields( $attribute, 'create')
                                            <label> tr: </label>
                                            #formFields( $attribute, 'create')
                                            <label> tw: </label>
                                            #formFields( $attribute, 'create')
                                            <label> uc: </label>
                                            #formFields( $attribute, 'create')
                                            <label> uo: </label>
                                            #formFields( $attribute, 'create')
                                        </div>

                                        <button className="btn btn-success" onClick={this.saveOrUpdateGovHydroIEEE2}>Save</button>
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

export default CreateGovHydroIEEE2Component
