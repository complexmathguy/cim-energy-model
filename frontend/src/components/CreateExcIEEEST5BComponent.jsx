import React, { Component } from 'react'
import ExcIEEEST5BService from '../services/ExcIEEEST5BService';

class CreateExcIEEEST5BComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            // step 2
            id: this.props.match.params.id,
                kc: '',
                kr: '',
                t1: '',
                tb1: '',
                tb2: '',
                tc1: '',
                tc2: '',
                tob1: '',
                tob2: '',
                toc1: '',
                toc2: '',
                tub1: '',
                tub2: '',
                tuc1: '',
                tuc2: '',
                vrmax: '',
                vrmin: ''
        }
        this.changekcHandler = this.changekcHandler.bind(this);
        this.changekrHandler = this.changekrHandler.bind(this);
        this.changet1Handler = this.changet1Handler.bind(this);
        this.changetb1Handler = this.changetb1Handler.bind(this);
        this.changetb2Handler = this.changetb2Handler.bind(this);
        this.changetc1Handler = this.changetc1Handler.bind(this);
        this.changetc2Handler = this.changetc2Handler.bind(this);
        this.changetob1Handler = this.changetob1Handler.bind(this);
        this.changetob2Handler = this.changetob2Handler.bind(this);
        this.changetoc1Handler = this.changetoc1Handler.bind(this);
        this.changetoc2Handler = this.changetoc2Handler.bind(this);
        this.changetub1Handler = this.changetub1Handler.bind(this);
        this.changetub2Handler = this.changetub2Handler.bind(this);
        this.changetuc1Handler = this.changetuc1Handler.bind(this);
        this.changetuc2Handler = this.changetuc2Handler.bind(this);
        this.changevrmaxHandler = this.changevrmaxHandler.bind(this);
        this.changevrminHandler = this.changevrminHandler.bind(this);
    }

    // step 3
    componentDidMount(){

        // step 4
        if(this.state.id === '_add'){
            return
        }else{
            ExcIEEEST5BService.getExcIEEEST5BById(this.state.id).then( (res) =>{
                let excIEEEST5B = res.data;
                this.setState({
                    kc: excIEEEST5B.kc,
                    kr: excIEEEST5B.kr,
                    t1: excIEEEST5B.t1,
                    tb1: excIEEEST5B.tb1,
                    tb2: excIEEEST5B.tb2,
                    tc1: excIEEEST5B.tc1,
                    tc2: excIEEEST5B.tc2,
                    tob1: excIEEEST5B.tob1,
                    tob2: excIEEEST5B.tob2,
                    toc1: excIEEEST5B.toc1,
                    toc2: excIEEEST5B.toc2,
                    tub1: excIEEEST5B.tub1,
                    tub2: excIEEEST5B.tub2,
                    tuc1: excIEEEST5B.tuc1,
                    tuc2: excIEEEST5B.tuc2,
                    vrmax: excIEEEST5B.vrmax,
                    vrmin: excIEEEST5B.vrmin
                });
            });
        }        
    }
    saveOrUpdateExcIEEEST5B = (e) => {
        e.preventDefault();
        let excIEEEST5B = {
                excIEEEST5BId: this.state.id,
                kc: this.state.kc,
                kr: this.state.kr,
                t1: this.state.t1,
                tb1: this.state.tb1,
                tb2: this.state.tb2,
                tc1: this.state.tc1,
                tc2: this.state.tc2,
                tob1: this.state.tob1,
                tob2: this.state.tob2,
                toc1: this.state.toc1,
                toc2: this.state.toc2,
                tub1: this.state.tub1,
                tub2: this.state.tub2,
                tuc1: this.state.tuc1,
                tuc2: this.state.tuc2,
                vrmax: this.state.vrmax,
                vrmin: this.state.vrmin
            };
        console.log('excIEEEST5B => ' + JSON.stringify(excIEEEST5B));

        // step 5
        if(this.state.id === '_add'){
            excIEEEST5B.excIEEEST5BId=''
            ExcIEEEST5BService.createExcIEEEST5B(excIEEEST5B).then(res =>{
                this.props.history.push('/excIEEEST5Bs');
            });
        }else{
            ExcIEEEST5BService.updateExcIEEEST5B(excIEEEST5B).then( res => {
                this.props.history.push('/excIEEEST5Bs');
            });
        }
    }
    
    changekcHandler= (event) => {
        this.setState({kc: event.target.value});
    }
    changekrHandler= (event) => {
        this.setState({kr: event.target.value});
    }
    changet1Handler= (event) => {
        this.setState({t1: event.target.value});
    }
    changetb1Handler= (event) => {
        this.setState({tb1: event.target.value});
    }
    changetb2Handler= (event) => {
        this.setState({tb2: event.target.value});
    }
    changetc1Handler= (event) => {
        this.setState({tc1: event.target.value});
    }
    changetc2Handler= (event) => {
        this.setState({tc2: event.target.value});
    }
    changetob1Handler= (event) => {
        this.setState({tob1: event.target.value});
    }
    changetob2Handler= (event) => {
        this.setState({tob2: event.target.value});
    }
    changetoc1Handler= (event) => {
        this.setState({toc1: event.target.value});
    }
    changetoc2Handler= (event) => {
        this.setState({toc2: event.target.value});
    }
    changetub1Handler= (event) => {
        this.setState({tub1: event.target.value});
    }
    changetub2Handler= (event) => {
        this.setState({tub2: event.target.value});
    }
    changetuc1Handler= (event) => {
        this.setState({tuc1: event.target.value});
    }
    changetuc2Handler= (event) => {
        this.setState({tuc2: event.target.value});
    }
    changevrmaxHandler= (event) => {
        this.setState({vrmax: event.target.value});
    }
    changevrminHandler= (event) => {
        this.setState({vrmin: event.target.value});
    }

    cancel(){
        this.props.history.push('/excIEEEST5Bs');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add ExcIEEEST5B</h3>
        }else{
            return <h3 className="text-center">Update ExcIEEEST5B</h3>
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
                                            <label> kc: </label>
                                            #formFields( $attribute, 'create')
                                            <label> kr: </label>
                                            #formFields( $attribute, 'create')
                                            <label> t1: </label>
                                            #formFields( $attribute, 'create')
                                            <label> tb1: </label>
                                            #formFields( $attribute, 'create')
                                            <label> tb2: </label>
                                            #formFields( $attribute, 'create')
                                            <label> tc1: </label>
                                            #formFields( $attribute, 'create')
                                            <label> tc2: </label>
                                            #formFields( $attribute, 'create')
                                            <label> tob1: </label>
                                            #formFields( $attribute, 'create')
                                            <label> tob2: </label>
                                            #formFields( $attribute, 'create')
                                            <label> toc1: </label>
                                            #formFields( $attribute, 'create')
                                            <label> toc2: </label>
                                            #formFields( $attribute, 'create')
                                            <label> tub1: </label>
                                            #formFields( $attribute, 'create')
                                            <label> tub2: </label>
                                            #formFields( $attribute, 'create')
                                            <label> tuc1: </label>
                                            #formFields( $attribute, 'create')
                                            <label> tuc2: </label>
                                            #formFields( $attribute, 'create')
                                            <label> vrmax: </label>
                                            #formFields( $attribute, 'create')
                                            <label> vrmin: </label>
                                            #formFields( $attribute, 'create')
                                        </div>

                                        <button className="btn btn-success" onClick={this.saveOrUpdateExcIEEEST5B}>Save</button>
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

export default CreateExcIEEEST5BComponent
