import React, { Component } from 'react'
import LoadGenericNonLinearService from '../services/LoadGenericNonLinearService';

class UpdateLoadGenericNonLinearComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
                bs: '',
                bt: '',
                genericNonLinearLoadModelType: '',
                ls: '',
                lt: '',
                pt: '',
                qt: '',
                tp: '',
                tq: ''
        }
        this.updateLoadGenericNonLinear = this.updateLoadGenericNonLinear.bind(this);

        this.changebsHandler = this.changebsHandler.bind(this);
        this.changebtHandler = this.changebtHandler.bind(this);
        this.changegenericNonLinearLoadModelTypeHandler = this.changegenericNonLinearLoadModelTypeHandler.bind(this);
        this.changelsHandler = this.changelsHandler.bind(this);
        this.changeltHandler = this.changeltHandler.bind(this);
        this.changeptHandler = this.changeptHandler.bind(this);
        this.changeqtHandler = this.changeqtHandler.bind(this);
        this.changetpHandler = this.changetpHandler.bind(this);
        this.changetqHandler = this.changetqHandler.bind(this);
    }

    componentDidMount(){
        LoadGenericNonLinearService.getLoadGenericNonLinearById(this.state.id).then( (res) =>{
            let loadGenericNonLinear = res.data;
            this.setState({
                bs: loadGenericNonLinear.bs,
                bt: loadGenericNonLinear.bt,
                genericNonLinearLoadModelType: loadGenericNonLinear.genericNonLinearLoadModelType,
                ls: loadGenericNonLinear.ls,
                lt: loadGenericNonLinear.lt,
                pt: loadGenericNonLinear.pt,
                qt: loadGenericNonLinear.qt,
                tp: loadGenericNonLinear.tp,
                tq: loadGenericNonLinear.tq
            });
        });
    }

    updateLoadGenericNonLinear = (e) => {
        e.preventDefault();
        let loadGenericNonLinear = {
            loadGenericNonLinearId: this.state.id,
            bs: this.state.bs,
            bt: this.state.bt,
            genericNonLinearLoadModelType: this.state.genericNonLinearLoadModelType,
            ls: this.state.ls,
            lt: this.state.lt,
            pt: this.state.pt,
            qt: this.state.qt,
            tp: this.state.tp,
            tq: this.state.tq
        };
        console.log('loadGenericNonLinear => ' + JSON.stringify(loadGenericNonLinear));
        console.log('id => ' + JSON.stringify(this.state.id));
        LoadGenericNonLinearService.updateLoadGenericNonLinear(loadGenericNonLinear).then( res => {
            this.props.history.push('/loadGenericNonLinears');
        });
    }

    changebsHandler= (event) => {
        this.setState({bs: event.target.value});
    }
    changebtHandler= (event) => {
        this.setState({bt: event.target.value});
    }
    changegenericNonLinearLoadModelTypeHandler= (event) => {
        this.setState({genericNonLinearLoadModelType: event.target.value});
    }
    changelsHandler= (event) => {
        this.setState({ls: event.target.value});
    }
    changeltHandler= (event) => {
        this.setState({lt: event.target.value});
    }
    changeptHandler= (event) => {
        this.setState({pt: event.target.value});
    }
    changeqtHandler= (event) => {
        this.setState({qt: event.target.value});
    }
    changetpHandler= (event) => {
        this.setState({tp: event.target.value});
    }
    changetqHandler= (event) => {
        this.setState({tq: event.target.value});
    }

    cancel(){
        this.props.history.push('/loadGenericNonLinears');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update LoadGenericNonLinear</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                            <label> bs: </label>
                                            #formFields( $attribute, 'update')
                                            <label> bt: </label>
                                            #formFields( $attribute, 'update')
                                            <label> genericNonLinearLoadModelType: </label>
                                            #formFields( $attribute, 'update')
                                            <label> ls: </label>
                                            #formFields( $attribute, 'update')
                                            <label> lt: </label>
                                            #formFields( $attribute, 'update')
                                            <label> pt: </label>
                                            #formFields( $attribute, 'update')
                                            <label> qt: </label>
                                            #formFields( $attribute, 'update')
                                            <label> tp: </label>
                                            #formFields( $attribute, 'update')
                                            <label> tq: </label>
                                            #formFields( $attribute, 'update')
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateLoadGenericNonLinear}>Save</button>
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

export default UpdateLoadGenericNonLinearComponent
