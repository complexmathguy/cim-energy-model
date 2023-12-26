import React, { Component } from 'react'
import ExcAVR5Service from '../services/ExcAVR5Service';

class UpdateExcAVR5Component extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
                ka: '',
                rex: '',
                ta: ''
        }
        this.updateExcAVR5 = this.updateExcAVR5.bind(this);

        this.changekaHandler = this.changekaHandler.bind(this);
        this.changerexHandler = this.changerexHandler.bind(this);
        this.changetaHandler = this.changetaHandler.bind(this);
    }

    componentDidMount(){
        ExcAVR5Service.getExcAVR5ById(this.state.id).then( (res) =>{
            let excAVR5 = res.data;
            this.setState({
                ka: excAVR5.ka,
                rex: excAVR5.rex,
                ta: excAVR5.ta
            });
        });
    }

    updateExcAVR5 = (e) => {
        e.preventDefault();
        let excAVR5 = {
            excAVR5Id: this.state.id,
            ka: this.state.ka,
            rex: this.state.rex,
            ta: this.state.ta
        };
        console.log('excAVR5 => ' + JSON.stringify(excAVR5));
        console.log('id => ' + JSON.stringify(this.state.id));
        ExcAVR5Service.updateExcAVR5(excAVR5).then( res => {
            this.props.history.push('/excAVR5s');
        });
    }

    changekaHandler= (event) => {
        this.setState({ka: event.target.value});
    }
    changerexHandler= (event) => {
        this.setState({rex: event.target.value});
    }
    changetaHandler= (event) => {
        this.setState({ta: event.target.value});
    }

    cancel(){
        this.props.history.push('/excAVR5s');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update ExcAVR5</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                            <label> ka: </label>
                                            #formFields( $attribute, 'update')
                                            <label> rex: </label>
                                            #formFields( $attribute, 'update')
                                            <label> ta: </label>
                                            #formFields( $attribute, 'update')
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateExcAVR5}>Save</button>
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

export default UpdateExcAVR5Component
