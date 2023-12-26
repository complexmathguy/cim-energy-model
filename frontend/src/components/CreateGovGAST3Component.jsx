import React, { Component } from 'react'
import GovGAST3Service from '../services/GovGAST3Service';

class CreateGovGAST3Component extends Component {
    constructor(props) {
        super(props)

        this.state = {
            // step 2
            id: this.props.match.params.id,
                bca: '',
                bp: '',
                dtc: '',
                ka: '',
                kac: '',
                kca: '',
                ksi: '',
                ky: '',
                mnef: '',
                mxef: '',
                rcmn: '',
                rcmx: '',
                tac: '',
                tc: '',
                td: '',
                tfen: '',
                tg: '',
                tsi: '',
                tt: '',
                ttc: '',
                ty: ''
        }
        this.changebcaHandler = this.changebcaHandler.bind(this);
        this.changebpHandler = this.changebpHandler.bind(this);
        this.changedtcHandler = this.changedtcHandler.bind(this);
        this.changekaHandler = this.changekaHandler.bind(this);
        this.changekacHandler = this.changekacHandler.bind(this);
        this.changekcaHandler = this.changekcaHandler.bind(this);
        this.changeksiHandler = this.changeksiHandler.bind(this);
        this.changekyHandler = this.changekyHandler.bind(this);
        this.changemnefHandler = this.changemnefHandler.bind(this);
        this.changemxefHandler = this.changemxefHandler.bind(this);
        this.changercmnHandler = this.changercmnHandler.bind(this);
        this.changercmxHandler = this.changercmxHandler.bind(this);
        this.changetacHandler = this.changetacHandler.bind(this);
        this.changetcHandler = this.changetcHandler.bind(this);
        this.changetdHandler = this.changetdHandler.bind(this);
        this.changetfenHandler = this.changetfenHandler.bind(this);
        this.changetgHandler = this.changetgHandler.bind(this);
        this.changetsiHandler = this.changetsiHandler.bind(this);
        this.changettHandler = this.changettHandler.bind(this);
        this.changettcHandler = this.changettcHandler.bind(this);
        this.changetyHandler = this.changetyHandler.bind(this);
    }

    // step 3
    componentDidMount(){

        // step 4
        if(this.state.id === '_add'){
            return
        }else{
            GovGAST3Service.getGovGAST3ById(this.state.id).then( (res) =>{
                let govGAST3 = res.data;
                this.setState({
                    bca: govGAST3.bca,
                    bp: govGAST3.bp,
                    dtc: govGAST3.dtc,
                    ka: govGAST3.ka,
                    kac: govGAST3.kac,
                    kca: govGAST3.kca,
                    ksi: govGAST3.ksi,
                    ky: govGAST3.ky,
                    mnef: govGAST3.mnef,
                    mxef: govGAST3.mxef,
                    rcmn: govGAST3.rcmn,
                    rcmx: govGAST3.rcmx,
                    tac: govGAST3.tac,
                    tc: govGAST3.tc,
                    td: govGAST3.td,
                    tfen: govGAST3.tfen,
                    tg: govGAST3.tg,
                    tsi: govGAST3.tsi,
                    tt: govGAST3.tt,
                    ttc: govGAST3.ttc,
                    ty: govGAST3.ty
                });
            });
        }        
    }
    saveOrUpdateGovGAST3 = (e) => {
        e.preventDefault();
        let govGAST3 = {
                govGAST3Id: this.state.id,
                bca: this.state.bca,
                bp: this.state.bp,
                dtc: this.state.dtc,
                ka: this.state.ka,
                kac: this.state.kac,
                kca: this.state.kca,
                ksi: this.state.ksi,
                ky: this.state.ky,
                mnef: this.state.mnef,
                mxef: this.state.mxef,
                rcmn: this.state.rcmn,
                rcmx: this.state.rcmx,
                tac: this.state.tac,
                tc: this.state.tc,
                td: this.state.td,
                tfen: this.state.tfen,
                tg: this.state.tg,
                tsi: this.state.tsi,
                tt: this.state.tt,
                ttc: this.state.ttc,
                ty: this.state.ty
            };
        console.log('govGAST3 => ' + JSON.stringify(govGAST3));

        // step 5
        if(this.state.id === '_add'){
            govGAST3.govGAST3Id=''
            GovGAST3Service.createGovGAST3(govGAST3).then(res =>{
                this.props.history.push('/govGAST3s');
            });
        }else{
            GovGAST3Service.updateGovGAST3(govGAST3).then( res => {
                this.props.history.push('/govGAST3s');
            });
        }
    }
    
    changebcaHandler= (event) => {
        this.setState({bca: event.target.value});
    }
    changebpHandler= (event) => {
        this.setState({bp: event.target.value});
    }
    changedtcHandler= (event) => {
        this.setState({dtc: event.target.value});
    }
    changekaHandler= (event) => {
        this.setState({ka: event.target.value});
    }
    changekacHandler= (event) => {
        this.setState({kac: event.target.value});
    }
    changekcaHandler= (event) => {
        this.setState({kca: event.target.value});
    }
    changeksiHandler= (event) => {
        this.setState({ksi: event.target.value});
    }
    changekyHandler= (event) => {
        this.setState({ky: event.target.value});
    }
    changemnefHandler= (event) => {
        this.setState({mnef: event.target.value});
    }
    changemxefHandler= (event) => {
        this.setState({mxef: event.target.value});
    }
    changercmnHandler= (event) => {
        this.setState({rcmn: event.target.value});
    }
    changercmxHandler= (event) => {
        this.setState({rcmx: event.target.value});
    }
    changetacHandler= (event) => {
        this.setState({tac: event.target.value});
    }
    changetcHandler= (event) => {
        this.setState({tc: event.target.value});
    }
    changetdHandler= (event) => {
        this.setState({td: event.target.value});
    }
    changetfenHandler= (event) => {
        this.setState({tfen: event.target.value});
    }
    changetgHandler= (event) => {
        this.setState({tg: event.target.value});
    }
    changetsiHandler= (event) => {
        this.setState({tsi: event.target.value});
    }
    changettHandler= (event) => {
        this.setState({tt: event.target.value});
    }
    changettcHandler= (event) => {
        this.setState({ttc: event.target.value});
    }
    changetyHandler= (event) => {
        this.setState({ty: event.target.value});
    }

    cancel(){
        this.props.history.push('/govGAST3s');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add GovGAST3</h3>
        }else{
            return <h3 className="text-center">Update GovGAST3</h3>
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
                                            <label> bca: </label>
                                            #formFields( $attribute, 'create')
                                            <label> bp: </label>
                                            #formFields( $attribute, 'create')
                                            <label> dtc: </label>
                                            #formFields( $attribute, 'create')
                                            <label> ka: </label>
                                            #formFields( $attribute, 'create')
                                            <label> kac: </label>
                                            #formFields( $attribute, 'create')
                                            <label> kca: </label>
                                            #formFields( $attribute, 'create')
                                            <label> ksi: </label>
                                            #formFields( $attribute, 'create')
                                            <label> ky: </label>
                                            #formFields( $attribute, 'create')
                                            <label> mnef: </label>
                                            #formFields( $attribute, 'create')
                                            <label> mxef: </label>
                                            #formFields( $attribute, 'create')
                                            <label> rcmn: </label>
                                            #formFields( $attribute, 'create')
                                            <label> rcmx: </label>
                                            #formFields( $attribute, 'create')
                                            <label> tac: </label>
                                            #formFields( $attribute, 'create')
                                            <label> tc: </label>
                                            #formFields( $attribute, 'create')
                                            <label> td: </label>
                                            #formFields( $attribute, 'create')
                                            <label> tfen: </label>
                                            #formFields( $attribute, 'create')
                                            <label> tg: </label>
                                            #formFields( $attribute, 'create')
                                            <label> tsi: </label>
                                            #formFields( $attribute, 'create')
                                            <label> tt: </label>
                                            #formFields( $attribute, 'create')
                                            <label> ttc: </label>
                                            #formFields( $attribute, 'create')
                                            <label> ty: </label>
                                            #formFields( $attribute, 'create')
                                        </div>

                                        <button className="btn btn-success" onClick={this.saveOrUpdateGovGAST3}>Save</button>
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

export default CreateGovGAST3Component
