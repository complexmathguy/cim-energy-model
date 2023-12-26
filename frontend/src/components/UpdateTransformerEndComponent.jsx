import React, { Component } from 'react'
import TransformerEndService from '../services/TransformerEndService';

class UpdateTransformerEndComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
                endNumber: '',
                grounded: '',
                rground: '',
                xground: ''
        }
        this.updateTransformerEnd = this.updateTransformerEnd.bind(this);

        this.changeendNumberHandler = this.changeendNumberHandler.bind(this);
        this.changegroundedHandler = this.changegroundedHandler.bind(this);
        this.changergroundHandler = this.changergroundHandler.bind(this);
        this.changexgroundHandler = this.changexgroundHandler.bind(this);
    }

    componentDidMount(){
        TransformerEndService.getTransformerEndById(this.state.id).then( (res) =>{
            let transformerEnd = res.data;
            this.setState({
                endNumber: transformerEnd.endNumber,
                grounded: transformerEnd.grounded,
                rground: transformerEnd.rground,
                xground: transformerEnd.xground
            });
        });
    }

    updateTransformerEnd = (e) => {
        e.preventDefault();
        let transformerEnd = {
            transformerEndId: this.state.id,
            endNumber: this.state.endNumber,
            grounded: this.state.grounded,
            rground: this.state.rground,
            xground: this.state.xground
        };
        console.log('transformerEnd => ' + JSON.stringify(transformerEnd));
        console.log('id => ' + JSON.stringify(this.state.id));
        TransformerEndService.updateTransformerEnd(transformerEnd).then( res => {
            this.props.history.push('/transformerEnds');
        });
    }

    changeendNumberHandler= (event) => {
        this.setState({endNumber: event.target.value});
    }
    changegroundedHandler= (event) => {
        this.setState({grounded: event.target.value});
    }
    changergroundHandler= (event) => {
        this.setState({rground: event.target.value});
    }
    changexgroundHandler= (event) => {
        this.setState({xground: event.target.value});
    }

    cancel(){
        this.props.history.push('/transformerEnds');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update TransformerEnd</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                            <label> endNumber: </label>
                                            #formFields( $attribute, 'update')
                                            <label> grounded: </label>
                                            #formFields( $attribute, 'update')
                                            <label> rground: </label>
                                            #formFields( $attribute, 'update')
                                            <label> xground: </label>
                                            #formFields( $attribute, 'update')
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateTransformerEnd}>Save</button>
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

export default UpdateTransformerEndComponent
