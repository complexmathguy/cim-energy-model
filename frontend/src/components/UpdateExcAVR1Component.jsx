import React, { Component } from 'react'
import ExcAVR1Service from '../services/ExcAVR1Service';

class UpdateExcAVR1Component extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
                e1: '',
                e2: '',
                ka: '',
                kf: '',
                se1: '',
                se2: '',
                ta: '',
                tb: '',
                te: '',
                tf: '',
                vrmn: '',
                vrmx: ''
        }
        this.updateExcAVR1 = this.updateExcAVR1.bind(this);

        this.changee1Handler = this.changee1Handler.bind(this);
        this.changee2Handler = this.changee2Handler.bind(this);
        this.changekaHandler = this.changekaHandler.bind(this);
        this.changekfHandler = this.changekfHandler.bind(this);
        this.changese1Handler = this.changese1Handler.bind(this);
        this.changese2Handler = this.changese2Handler.bind(this);
        this.changetaHandler = this.changetaHandler.bind(this);
        this.changetbHandler = this.changetbHandler.bind(this);
        this.changeteHandler = this.changeteHandler.bind(this);
        this.changetfHandler = this.changetfHandler.bind(this);
        this.changevrmnHandler = this.changevrmnHandler.bind(this);
        this.changevrmxHandler = this.changevrmxHandler.bind(this);
    }

    componentDidMount(){
        ExcAVR1Service.getExcAVR1ById(this.state.id).then( (res) =>{
            let excAVR1 = res.data;
            this.setState({
                e1: excAVR1.e1,
                e2: excAVR1.e2,
                ka: excAVR1.ka,
                kf: excAVR1.kf,
                se1: excAVR1.se1,
                se2: excAVR1.se2,
                ta: excAVR1.ta,
                tb: excAVR1.tb,
                te: excAVR1.te,
                tf: excAVR1.tf,
                vrmn: excAVR1.vrmn,
                vrmx: excAVR1.vrmx
            });
        });
    }

    updateExcAVR1 = (e) => {
        e.preventDefault();
        let excAVR1 = {
            excAVR1Id: this.state.id,
            e1: this.state.e1,
            e2: this.state.e2,
            ka: this.state.ka,
            kf: this.state.kf,
            se1: this.state.se1,
            se2: this.state.se2,
            ta: this.state.ta,
            tb: this.state.tb,
            te: this.state.te,
            tf: this.state.tf,
            vrmn: this.state.vrmn,
            vrmx: this.state.vrmx
        };
        console.log('excAVR1 => ' + JSON.stringify(excAVR1));
        console.log('id => ' + JSON.stringify(this.state.id));
        ExcAVR1Service.updateExcAVR1(excAVR1).then( res => {
            this.props.history.push('/excAVR1s');
        });
    }

    changee1Handler= (event) => {
        this.setState({e1: event.target.value});
    }
    changee2Handler= (event) => {
        this.setState({e2: event.target.value});
    }
    changekaHandler= (event) => {
        this.setState({ka: event.target.value});
    }
    changekfHandler= (event) => {
        this.setState({kf: event.target.value});
    }
    changese1Handler= (event) => {
        this.setState({se1: event.target.value});
    }
    changese2Handler= (event) => {
        this.setState({se2: event.target.value});
    }
    changetaHandler= (event) => {
        this.setState({ta: event.target.value});
    }
    changetbHandler= (event) => {
        this.setState({tb: event.target.value});
    }
    changeteHandler= (event) => {
        this.setState({te: event.target.value});
    }
    changetfHandler= (event) => {
        this.setState({tf: event.target.value});
    }
    changevrmnHandler= (event) => {
        this.setState({vrmn: event.target.value});
    }
    changevrmxHandler= (event) => {
        this.setState({vrmx: event.target.value});
    }

    cancel(){
        this.props.history.push('/excAVR1s');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update ExcAVR1</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                            <label> e1: </label>
                                            #formFields( $attribute, 'update')
                                            <label> e2: </label>
                                            #formFields( $attribute, 'update')
                                            <label> ka: </label>
                                            #formFields( $attribute, 'update')
                                            <label> kf: </label>
                                            #formFields( $attribute, 'update')
                                            <label> se1: </label>
                                            #formFields( $attribute, 'update')
                                            <label> se2: </label>
                                            #formFields( $attribute, 'update')
                                            <label> ta: </label>
                                            #formFields( $attribute, 'update')
                                            <label> tb: </label>
                                            #formFields( $attribute, 'update')
                                            <label> te: </label>
                                            #formFields( $attribute, 'update')
                                            <label> tf: </label>
                                            #formFields( $attribute, 'update')
                                            <label> vrmn: </label>
                                            #formFields( $attribute, 'update')
                                            <label> vrmx: </label>
                                            #formFields( $attribute, 'update')
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateExcAVR1}>Save</button>
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

export default UpdateExcAVR1Component
