import React, { Component } from 'react'
import ExcAVR4Service from '../services/ExcAVR4Service';

class UpdateExcAVR4Component extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
                imul: '',
                ka: '',
                ke: '',
                kif: '',
                t1: '',
                t1if: '',
                t2: '',
                t3: '',
                t4: '',
                tif: '',
                vfmn: '',
                vfmx: '',
                vrmn: '',
                vrmx: ''
        }
        this.updateExcAVR4 = this.updateExcAVR4.bind(this);

        this.changeimulHandler = this.changeimulHandler.bind(this);
        this.changekaHandler = this.changekaHandler.bind(this);
        this.changekeHandler = this.changekeHandler.bind(this);
        this.changekifHandler = this.changekifHandler.bind(this);
        this.changet1Handler = this.changet1Handler.bind(this);
        this.changet1ifHandler = this.changet1ifHandler.bind(this);
        this.changet2Handler = this.changet2Handler.bind(this);
        this.changet3Handler = this.changet3Handler.bind(this);
        this.changet4Handler = this.changet4Handler.bind(this);
        this.changetifHandler = this.changetifHandler.bind(this);
        this.changevfmnHandler = this.changevfmnHandler.bind(this);
        this.changevfmxHandler = this.changevfmxHandler.bind(this);
        this.changevrmnHandler = this.changevrmnHandler.bind(this);
        this.changevrmxHandler = this.changevrmxHandler.bind(this);
    }

    componentDidMount(){
        ExcAVR4Service.getExcAVR4ById(this.state.id).then( (res) =>{
            let excAVR4 = res.data;
            this.setState({
                imul: excAVR4.imul,
                ka: excAVR4.ka,
                ke: excAVR4.ke,
                kif: excAVR4.kif,
                t1: excAVR4.t1,
                t1if: excAVR4.t1if,
                t2: excAVR4.t2,
                t3: excAVR4.t3,
                t4: excAVR4.t4,
                tif: excAVR4.tif,
                vfmn: excAVR4.vfmn,
                vfmx: excAVR4.vfmx,
                vrmn: excAVR4.vrmn,
                vrmx: excAVR4.vrmx
            });
        });
    }

    updateExcAVR4 = (e) => {
        e.preventDefault();
        let excAVR4 = {
            excAVR4Id: this.state.id,
            imul: this.state.imul,
            ka: this.state.ka,
            ke: this.state.ke,
            kif: this.state.kif,
            t1: this.state.t1,
            t1if: this.state.t1if,
            t2: this.state.t2,
            t3: this.state.t3,
            t4: this.state.t4,
            tif: this.state.tif,
            vfmn: this.state.vfmn,
            vfmx: this.state.vfmx,
            vrmn: this.state.vrmn,
            vrmx: this.state.vrmx
        };
        console.log('excAVR4 => ' + JSON.stringify(excAVR4));
        console.log('id => ' + JSON.stringify(this.state.id));
        ExcAVR4Service.updateExcAVR4(excAVR4).then( res => {
            this.props.history.push('/excAVR4s');
        });
    }

    changeimulHandler= (event) => {
        this.setState({imul: event.target.value});
    }
    changekaHandler= (event) => {
        this.setState({ka: event.target.value});
    }
    changekeHandler= (event) => {
        this.setState({ke: event.target.value});
    }
    changekifHandler= (event) => {
        this.setState({kif: event.target.value});
    }
    changet1Handler= (event) => {
        this.setState({t1: event.target.value});
    }
    changet1ifHandler= (event) => {
        this.setState({t1if: event.target.value});
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
    changetifHandler= (event) => {
        this.setState({tif: event.target.value});
    }
    changevfmnHandler= (event) => {
        this.setState({vfmn: event.target.value});
    }
    changevfmxHandler= (event) => {
        this.setState({vfmx: event.target.value});
    }
    changevrmnHandler= (event) => {
        this.setState({vrmn: event.target.value});
    }
    changevrmxHandler= (event) => {
        this.setState({vrmx: event.target.value});
    }

    cancel(){
        this.props.history.push('/excAVR4s');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update ExcAVR4</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                            <label> imul: </label>
                                            #formFields( $attribute, 'update')
                                            <label> ka: </label>
                                            #formFields( $attribute, 'update')
                                            <label> ke: </label>
                                            #formFields( $attribute, 'update')
                                            <label> kif: </label>
                                            #formFields( $attribute, 'update')
                                            <label> t1: </label>
                                            #formFields( $attribute, 'update')
                                            <label> t1if: </label>
                                            #formFields( $attribute, 'update')
                                            <label> t2: </label>
                                            #formFields( $attribute, 'update')
                                            <label> t3: </label>
                                            #formFields( $attribute, 'update')
                                            <label> t4: </label>
                                            #formFields( $attribute, 'update')
                                            <label> tif: </label>
                                            #formFields( $attribute, 'update')
                                            <label> vfmn: </label>
                                            #formFields( $attribute, 'update')
                                            <label> vfmx: </label>
                                            #formFields( $attribute, 'update')
                                            <label> vrmn: </label>
                                            #formFields( $attribute, 'update')
                                            <label> vrmx: </label>
                                            #formFields( $attribute, 'update')
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateExcAVR4}>Save</button>
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

export default UpdateExcAVR4Component
