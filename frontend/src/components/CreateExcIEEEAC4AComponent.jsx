import React, { Component } from 'react'
import ExcIEEEAC4AService from '../services/ExcIEEEAC4AService';

class CreateExcIEEEAC4AComponent extends Component {
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
            ExcIEEEAC4AService.getExcIEEEAC4AById(this.state.id).then( (res) =>{
                let excIEEEAC4A = res.data;
                this.setState({
                    ka: excIEEEAC4A.ka,
                    kc: excIEEEAC4A.kc,
                    ta: excIEEEAC4A.ta,
                    tb: excIEEEAC4A.tb,
                    tc: excIEEEAC4A.tc,
                    vimax: excIEEEAC4A.vimax,
                    vimin: excIEEEAC4A.vimin,
                    vrmax: excIEEEAC4A.vrmax,
                    vrmin: excIEEEAC4A.vrmin
                });
            });
        }        
    }
    saveOrUpdateExcIEEEAC4A = (e) => {
        e.preventDefault();
        let excIEEEAC4A = {
                excIEEEAC4AId: this.state.id,
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
        console.log('excIEEEAC4A => ' + JSON.stringify(excIEEEAC4A));

        // step 5
        if(this.state.id === '_add'){
            excIEEEAC4A.excIEEEAC4AId=''
            ExcIEEEAC4AService.createExcIEEEAC4A(excIEEEAC4A).then(res =>{
                this.props.history.push('/excIEEEAC4As');
            });
        }else{
            ExcIEEEAC4AService.updateExcIEEEAC4A(excIEEEAC4A).then( res => {
                this.props.history.push('/excIEEEAC4As');
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
        this.props.history.push('/excIEEEAC4As');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add ExcIEEEAC4A</h3>
        }else{
            return <h3 className="text-center">Update ExcIEEEAC4A</h3>
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

                                        <button className="btn btn-success" onClick={this.saveOrUpdateExcIEEEAC4A}>Save</button>
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

export default CreateExcIEEEAC4AComponent
