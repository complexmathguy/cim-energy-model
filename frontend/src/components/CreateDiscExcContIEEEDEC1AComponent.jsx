import React, { Component } from 'react'
import DiscExcContIEEEDEC1AService from '../services/DiscExcContIEEEDEC1AService';

class CreateDiscExcContIEEEDEC1AComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            // step 2
            id: this.props.match.params.id,
                esc: '',
                kan: '',
                ketl: '',
                tan: '',
                td: '',
                tl1: '',
                tl2: '',
                tw5: '',
                value: '',
                vanmax: '',
                vomax: '',
                vomin: '',
                vsmax: '',
                vsmin: '',
                vtc: '',
                vtlmt: '',
                vtm: '',
                vtn: ''
        }
        this.changeescHandler = this.changeescHandler.bind(this);
        this.changekanHandler = this.changekanHandler.bind(this);
        this.changeketlHandler = this.changeketlHandler.bind(this);
        this.changetanHandler = this.changetanHandler.bind(this);
        this.changetdHandler = this.changetdHandler.bind(this);
        this.changetl1Handler = this.changetl1Handler.bind(this);
        this.changetl2Handler = this.changetl2Handler.bind(this);
        this.changetw5Handler = this.changetw5Handler.bind(this);
        this.changevalueHandler = this.changevalueHandler.bind(this);
        this.changevanmaxHandler = this.changevanmaxHandler.bind(this);
        this.changevomaxHandler = this.changevomaxHandler.bind(this);
        this.changevominHandler = this.changevominHandler.bind(this);
        this.changevsmaxHandler = this.changevsmaxHandler.bind(this);
        this.changevsminHandler = this.changevsminHandler.bind(this);
        this.changevtcHandler = this.changevtcHandler.bind(this);
        this.changevtlmtHandler = this.changevtlmtHandler.bind(this);
        this.changevtmHandler = this.changevtmHandler.bind(this);
        this.changevtnHandler = this.changevtnHandler.bind(this);
    }

    // step 3
    componentDidMount(){

        // step 4
        if(this.state.id === '_add'){
            return
        }else{
            DiscExcContIEEEDEC1AService.getDiscExcContIEEEDEC1AById(this.state.id).then( (res) =>{
                let discExcContIEEEDEC1A = res.data;
                this.setState({
                    esc: discExcContIEEEDEC1A.esc,
                    kan: discExcContIEEEDEC1A.kan,
                    ketl: discExcContIEEEDEC1A.ketl,
                    tan: discExcContIEEEDEC1A.tan,
                    td: discExcContIEEEDEC1A.td,
                    tl1: discExcContIEEEDEC1A.tl1,
                    tl2: discExcContIEEEDEC1A.tl2,
                    tw5: discExcContIEEEDEC1A.tw5,
                    value: discExcContIEEEDEC1A.value,
                    vanmax: discExcContIEEEDEC1A.vanmax,
                    vomax: discExcContIEEEDEC1A.vomax,
                    vomin: discExcContIEEEDEC1A.vomin,
                    vsmax: discExcContIEEEDEC1A.vsmax,
                    vsmin: discExcContIEEEDEC1A.vsmin,
                    vtc: discExcContIEEEDEC1A.vtc,
                    vtlmt: discExcContIEEEDEC1A.vtlmt,
                    vtm: discExcContIEEEDEC1A.vtm,
                    vtn: discExcContIEEEDEC1A.vtn
                });
            });
        }        
    }
    saveOrUpdateDiscExcContIEEEDEC1A = (e) => {
        e.preventDefault();
        let discExcContIEEEDEC1A = {
                discExcContIEEEDEC1AId: this.state.id,
                esc: this.state.esc,
                kan: this.state.kan,
                ketl: this.state.ketl,
                tan: this.state.tan,
                td: this.state.td,
                tl1: this.state.tl1,
                tl2: this.state.tl2,
                tw5: this.state.tw5,
                value: this.state.value,
                vanmax: this.state.vanmax,
                vomax: this.state.vomax,
                vomin: this.state.vomin,
                vsmax: this.state.vsmax,
                vsmin: this.state.vsmin,
                vtc: this.state.vtc,
                vtlmt: this.state.vtlmt,
                vtm: this.state.vtm,
                vtn: this.state.vtn
            };
        console.log('discExcContIEEEDEC1A => ' + JSON.stringify(discExcContIEEEDEC1A));

        // step 5
        if(this.state.id === '_add'){
            discExcContIEEEDEC1A.discExcContIEEEDEC1AId=''
            DiscExcContIEEEDEC1AService.createDiscExcContIEEEDEC1A(discExcContIEEEDEC1A).then(res =>{
                this.props.history.push('/discExcContIEEEDEC1As');
            });
        }else{
            DiscExcContIEEEDEC1AService.updateDiscExcContIEEEDEC1A(discExcContIEEEDEC1A).then( res => {
                this.props.history.push('/discExcContIEEEDEC1As');
            });
        }
    }
    
    changeescHandler= (event) => {
        this.setState({esc: event.target.value});
    }
    changekanHandler= (event) => {
        this.setState({kan: event.target.value});
    }
    changeketlHandler= (event) => {
        this.setState({ketl: event.target.value});
    }
    changetanHandler= (event) => {
        this.setState({tan: event.target.value});
    }
    changetdHandler= (event) => {
        this.setState({td: event.target.value});
    }
    changetl1Handler= (event) => {
        this.setState({tl1: event.target.value});
    }
    changetl2Handler= (event) => {
        this.setState({tl2: event.target.value});
    }
    changetw5Handler= (event) => {
        this.setState({tw5: event.target.value});
    }
    changevalueHandler= (event) => {
        this.setState({value: event.target.value});
    }
    changevanmaxHandler= (event) => {
        this.setState({vanmax: event.target.value});
    }
    changevomaxHandler= (event) => {
        this.setState({vomax: event.target.value});
    }
    changevominHandler= (event) => {
        this.setState({vomin: event.target.value});
    }
    changevsmaxHandler= (event) => {
        this.setState({vsmax: event.target.value});
    }
    changevsminHandler= (event) => {
        this.setState({vsmin: event.target.value});
    }
    changevtcHandler= (event) => {
        this.setState({vtc: event.target.value});
    }
    changevtlmtHandler= (event) => {
        this.setState({vtlmt: event.target.value});
    }
    changevtmHandler= (event) => {
        this.setState({vtm: event.target.value});
    }
    changevtnHandler= (event) => {
        this.setState({vtn: event.target.value});
    }

    cancel(){
        this.props.history.push('/discExcContIEEEDEC1As');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add DiscExcContIEEEDEC1A</h3>
        }else{
            return <h3 className="text-center">Update DiscExcContIEEEDEC1A</h3>
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
                                            <label> esc: </label>
                                            #formFields( $attribute, 'create')
                                            <label> kan: </label>
                                            #formFields( $attribute, 'create')
                                            <label> ketl: </label>
                                            #formFields( $attribute, 'create')
                                            <label> tan: </label>
                                            #formFields( $attribute, 'create')
                                            <label> td: </label>
                                            #formFields( $attribute, 'create')
                                            <label> tl1: </label>
                                            #formFields( $attribute, 'create')
                                            <label> tl2: </label>
                                            #formFields( $attribute, 'create')
                                            <label> tw5: </label>
                                            #formFields( $attribute, 'create')
                                            <label> value: </label>
                                            #formFields( $attribute, 'create')
                                            <label> vanmax: </label>
                                            #formFields( $attribute, 'create')
                                            <label> vomax: </label>
                                            #formFields( $attribute, 'create')
                                            <label> vomin: </label>
                                            #formFields( $attribute, 'create')
                                            <label> vsmax: </label>
                                            #formFields( $attribute, 'create')
                                            <label> vsmin: </label>
                                            #formFields( $attribute, 'create')
                                            <label> vtc: </label>
                                            #formFields( $attribute, 'create')
                                            <label> vtlmt: </label>
                                            #formFields( $attribute, 'create')
                                            <label> vtm: </label>
                                            #formFields( $attribute, 'create')
                                            <label> vtn: </label>
                                            #formFields( $attribute, 'create')
                                        </div>

                                        <button className="btn btn-success" onClick={this.saveOrUpdateDiscExcContIEEEDEC1A}>Save</button>
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

export default CreateDiscExcContIEEEDEC1AComponent
