import React, { Component } from 'react'
import ExcAVR2Service from '../services/ExcAVR2Service';

class UpdateExcAVR2Component extends Component {
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
                tf1: '',
                tf2: '',
                vrmn: '',
                vrmx: ''
        }
        this.updateExcAVR2 = this.updateExcAVR2.bind(this);

        this.changee1Handler = this.changee1Handler.bind(this);
        this.changee2Handler = this.changee2Handler.bind(this);
        this.changekaHandler = this.changekaHandler.bind(this);
        this.changekfHandler = this.changekfHandler.bind(this);
        this.changese1Handler = this.changese1Handler.bind(this);
        this.changese2Handler = this.changese2Handler.bind(this);
        this.changetaHandler = this.changetaHandler.bind(this);
        this.changetbHandler = this.changetbHandler.bind(this);
        this.changeteHandler = this.changeteHandler.bind(this);
        this.changetf1Handler = this.changetf1Handler.bind(this);
        this.changetf2Handler = this.changetf2Handler.bind(this);
        this.changevrmnHandler = this.changevrmnHandler.bind(this);
        this.changevrmxHandler = this.changevrmxHandler.bind(this);
    }

    componentDidMount(){
        ExcAVR2Service.getExcAVR2ById(this.state.id).then( (res) =>{
            let excAVR2 = res.data;
            this.setState({
                e1: excAVR2.e1,
                e2: excAVR2.e2,
                ka: excAVR2.ka,
                kf: excAVR2.kf,
                se1: excAVR2.se1,
                se2: excAVR2.se2,
                ta: excAVR2.ta,
                tb: excAVR2.tb,
                te: excAVR2.te,
                tf1: excAVR2.tf1,
                tf2: excAVR2.tf2,
                vrmn: excAVR2.vrmn,
                vrmx: excAVR2.vrmx
            });
        });
    }

    updateExcAVR2 = (e) => {
        e.preventDefault();
        let excAVR2 = {
            excAVR2Id: this.state.id,
            e1: this.state.e1,
            e2: this.state.e2,
            ka: this.state.ka,
            kf: this.state.kf,
            se1: this.state.se1,
            se2: this.state.se2,
            ta: this.state.ta,
            tb: this.state.tb,
            te: this.state.te,
            tf1: this.state.tf1,
            tf2: this.state.tf2,
            vrmn: this.state.vrmn,
            vrmx: this.state.vrmx
        };
        console.log('excAVR2 => ' + JSON.stringify(excAVR2));
        console.log('id => ' + JSON.stringify(this.state.id));
        ExcAVR2Service.updateExcAVR2(excAVR2).then( res => {
            this.props.history.push('/excAVR2s');
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
    changetf1Handler= (event) => {
        this.setState({tf1: event.target.value});
    }
    changetf2Handler= (event) => {
        this.setState({tf2: event.target.value});
    }
    changevrmnHandler= (event) => {
        this.setState({vrmn: event.target.value});
    }
    changevrmxHandler= (event) => {
        this.setState({vrmx: event.target.value});
    }

    cancel(){
        this.props.history.push('/excAVR2s');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update ExcAVR2</h3>
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
                                            <label> tf1: </label>
                                            #formFields( $attribute, 'update')
                                            <label> tf2: </label>
                                            #formFields( $attribute, 'update')
                                            <label> vrmn: </label>
                                            #formFields( $attribute, 'update')
                                            <label> vrmx: </label>
                                            #formFields( $attribute, 'update')
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateExcAVR2}>Save</button>
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

export default UpdateExcAVR2Component
