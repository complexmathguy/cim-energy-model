import React, { Component } from 'react'
import ExcIEEEST7BService from '../services/ExcIEEEST7BService';

class CreateExcIEEEST7BComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            // step 2
            id: this.props.match.params.id,
                kh: '',
                kia: '',
                kl: '',
                kpa: '',
                oelin: '',
                tb: '',
                tc: '',
                tf: '',
                tg: '',
                tia: '',
                uelin: '',
                vmax: '',
                vmin: '',
                vrmax: '',
                vrmin: ''
        }
        this.changekhHandler = this.changekhHandler.bind(this);
        this.changekiaHandler = this.changekiaHandler.bind(this);
        this.changeklHandler = this.changeklHandler.bind(this);
        this.changekpaHandler = this.changekpaHandler.bind(this);
        this.changeoelinHandler = this.changeoelinHandler.bind(this);
        this.changetbHandler = this.changetbHandler.bind(this);
        this.changetcHandler = this.changetcHandler.bind(this);
        this.changetfHandler = this.changetfHandler.bind(this);
        this.changetgHandler = this.changetgHandler.bind(this);
        this.changetiaHandler = this.changetiaHandler.bind(this);
        this.changeuelinHandler = this.changeuelinHandler.bind(this);
        this.changevmaxHandler = this.changevmaxHandler.bind(this);
        this.changevminHandler = this.changevminHandler.bind(this);
        this.changevrmaxHandler = this.changevrmaxHandler.bind(this);
        this.changevrminHandler = this.changevrminHandler.bind(this);
    }

    // step 3
    componentDidMount(){

        // step 4
        if(this.state.id === '_add'){
            return
        }else{
            ExcIEEEST7BService.getExcIEEEST7BById(this.state.id).then( (res) =>{
                let excIEEEST7B = res.data;
                this.setState({
                    kh: excIEEEST7B.kh,
                    kia: excIEEEST7B.kia,
                    kl: excIEEEST7B.kl,
                    kpa: excIEEEST7B.kpa,
                    oelin: excIEEEST7B.oelin,
                    tb: excIEEEST7B.tb,
                    tc: excIEEEST7B.tc,
                    tf: excIEEEST7B.tf,
                    tg: excIEEEST7B.tg,
                    tia: excIEEEST7B.tia,
                    uelin: excIEEEST7B.uelin,
                    vmax: excIEEEST7B.vmax,
                    vmin: excIEEEST7B.vmin,
                    vrmax: excIEEEST7B.vrmax,
                    vrmin: excIEEEST7B.vrmin
                });
            });
        }        
    }
    saveOrUpdateExcIEEEST7B = (e) => {
        e.preventDefault();
        let excIEEEST7B = {
                excIEEEST7BId: this.state.id,
                kh: this.state.kh,
                kia: this.state.kia,
                kl: this.state.kl,
                kpa: this.state.kpa,
                oelin: this.state.oelin,
                tb: this.state.tb,
                tc: this.state.tc,
                tf: this.state.tf,
                tg: this.state.tg,
                tia: this.state.tia,
                uelin: this.state.uelin,
                vmax: this.state.vmax,
                vmin: this.state.vmin,
                vrmax: this.state.vrmax,
                vrmin: this.state.vrmin
            };
        console.log('excIEEEST7B => ' + JSON.stringify(excIEEEST7B));

        // step 5
        if(this.state.id === '_add'){
            excIEEEST7B.excIEEEST7BId=''
            ExcIEEEST7BService.createExcIEEEST7B(excIEEEST7B).then(res =>{
                this.props.history.push('/excIEEEST7Bs');
            });
        }else{
            ExcIEEEST7BService.updateExcIEEEST7B(excIEEEST7B).then( res => {
                this.props.history.push('/excIEEEST7Bs');
            });
        }
    }
    
    changekhHandler= (event) => {
        this.setState({kh: event.target.value});
    }
    changekiaHandler= (event) => {
        this.setState({kia: event.target.value});
    }
    changeklHandler= (event) => {
        this.setState({kl: event.target.value});
    }
    changekpaHandler= (event) => {
        this.setState({kpa: event.target.value});
    }
    changeoelinHandler= (event) => {
        this.setState({oelin: event.target.value});
    }
    changetbHandler= (event) => {
        this.setState({tb: event.target.value});
    }
    changetcHandler= (event) => {
        this.setState({tc: event.target.value});
    }
    changetfHandler= (event) => {
        this.setState({tf: event.target.value});
    }
    changetgHandler= (event) => {
        this.setState({tg: event.target.value});
    }
    changetiaHandler= (event) => {
        this.setState({tia: event.target.value});
    }
    changeuelinHandler= (event) => {
        this.setState({uelin: event.target.value});
    }
    changevmaxHandler= (event) => {
        this.setState({vmax: event.target.value});
    }
    changevminHandler= (event) => {
        this.setState({vmin: event.target.value});
    }
    changevrmaxHandler= (event) => {
        this.setState({vrmax: event.target.value});
    }
    changevrminHandler= (event) => {
        this.setState({vrmin: event.target.value});
    }

    cancel(){
        this.props.history.push('/excIEEEST7Bs');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add ExcIEEEST7B</h3>
        }else{
            return <h3 className="text-center">Update ExcIEEEST7B</h3>
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
                                            <label> kh: </label>
                                            #formFields( $attribute, 'create')
                                            <label> kia: </label>
                                            #formFields( $attribute, 'create')
                                            <label> kl: </label>
                                            #formFields( $attribute, 'create')
                                            <label> kpa: </label>
                                            #formFields( $attribute, 'create')
                                            <label> oelin: </label>
                                            #formFields( $attribute, 'create')
                                            <label> tb: </label>
                                            #formFields( $attribute, 'create')
                                            <label> tc: </label>
                                            #formFields( $attribute, 'create')
                                            <label> tf: </label>
                                            #formFields( $attribute, 'create')
                                            <label> tg: </label>
                                            #formFields( $attribute, 'create')
                                            <label> tia: </label>
                                            #formFields( $attribute, 'create')
                                            <label> uelin: </label>
                                            #formFields( $attribute, 'create')
                                            <label> vmax: </label>
                                            #formFields( $attribute, 'create')
                                            <label> vmin: </label>
                                            #formFields( $attribute, 'create')
                                            <label> vrmax: </label>
                                            #formFields( $attribute, 'create')
                                            <label> vrmin: </label>
                                            #formFields( $attribute, 'create')
                                        </div>

                                        <button className="btn btn-success" onClick={this.saveOrUpdateExcIEEEST7B}>Save</button>
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

export default CreateExcIEEEST7BComponent
