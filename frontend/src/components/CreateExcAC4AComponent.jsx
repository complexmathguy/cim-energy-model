import React, { Component } from 'react'
import ExcAC4AService from '../services/ExcAC4AService';

class CreateExcAC4AComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            // step 2
            id: this.props.match.params.id,
                ka: '',
                kc: '',
                ta: '',
                tb: '',
                tc: '',
                vimax: '',
                vimin: '',
                vrmax: '',
                vrmin: ''
        }
        this.changekaHandler = this.changekaHandler.bind(this);
        this.changekcHandler = this.changekcHandler.bind(this);
        this.changetaHandler = this.changetaHandler.bind(this);
        this.changetbHandler = this.changetbHandler.bind(this);
        this.changetcHandler = this.changetcHandler.bind(this);
        this.changevimaxHandler = this.changevimaxHandler.bind(this);
        this.changeviminHandler = this.changeviminHandler.bind(this);
        this.changevrmaxHandler = this.changevrmaxHandler.bind(this);
        this.changevrminHandler = this.changevrminHandler.bind(this);
    }

    // step 3
    componentDidMount(){

        // step 4
        if(this.state.id === '_add'){
            return
        }else{
            ExcAC4AService.getExcAC4AById(this.state.id).then( (res) =>{
                let excAC4A = res.data;
                this.setState({
                    ka: excAC4A.ka,
                    kc: excAC4A.kc,
                    ta: excAC4A.ta,
                    tb: excAC4A.tb,
                    tc: excAC4A.tc,
                    vimax: excAC4A.vimax,
                    vimin: excAC4A.vimin,
                    vrmax: excAC4A.vrmax,
                    vrmin: excAC4A.vrmin
                });
            });
        }        
    }
    saveOrUpdateExcAC4A = (e) => {
        e.preventDefault();
        let excAC4A = {
                excAC4AId: this.state.id,
                ka: this.state.ka,
                kc: this.state.kc,
                ta: this.state.ta,
                tb: this.state.tb,
                tc: this.state.tc,
                vimax: this.state.vimax,
                vimin: this.state.vimin,
                vrmax: this.state.vrmax,
                vrmin: this.state.vrmin
            };
        console.log('excAC4A => ' + JSON.stringify(excAC4A));

        // step 5
        if(this.state.id === '_add'){
            excAC4A.excAC4AId=''
            ExcAC4AService.createExcAC4A(excAC4A).then(res =>{
                this.props.history.push('/excAC4As');
            });
        }else{
            ExcAC4AService.updateExcAC4A(excAC4A).then( res => {
                this.props.history.push('/excAC4As');
            });
        }
    }
    
    changekaHandler= (event) => {
        this.setState({ka: event.target.value});
    }
    changekcHandler= (event) => {
        this.setState({kc: event.target.value});
    }
    changetaHandler= (event) => {
        this.setState({ta: event.target.value});
    }
    changetbHandler= (event) => {
        this.setState({tb: event.target.value});
    }
    changetcHandler= (event) => {
        this.setState({tc: event.target.value});
    }
    changevimaxHandler= (event) => {
        this.setState({vimax: event.target.value});
    }
    changeviminHandler= (event) => {
        this.setState({vimin: event.target.value});
    }
    changevrmaxHandler= (event) => {
        this.setState({vrmax: event.target.value});
    }
    changevrminHandler= (event) => {
        this.setState({vrmin: event.target.value});
    }

    cancel(){
        this.props.history.push('/excAC4As');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add ExcAC4A</h3>
        }else{
            return <h3 className="text-center">Update ExcAC4A</h3>
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
                                            <label> ka: </label>
                                            #formFields( $attribute, 'create')
                                            <label> kc: </label>
                                            #formFields( $attribute, 'create')
                                            <label> ta: </label>
                                            #formFields( $attribute, 'create')
                                            <label> tb: </label>
                                            #formFields( $attribute, 'create')
                                            <label> tc: </label>
                                            #formFields( $attribute, 'create')
                                            <label> vimax: </label>
                                            #formFields( $attribute, 'create')
                                            <label> vimin: </label>
                                            #formFields( $attribute, 'create')
                                            <label> vrmax: </label>
                                            #formFields( $attribute, 'create')
                                            <label> vrmin: </label>
                                            #formFields( $attribute, 'create')
                                        </div>

                                        <button className="btn btn-success" onClick={this.saveOrUpdateExcAC4A}>Save</button>
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

export default CreateExcAC4AComponent
