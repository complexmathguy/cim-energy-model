import React, { Component } from 'react'
import TextDiagramObjectService from '../services/TextDiagramObjectService';

class UpdateTextDiagramObjectComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
                text: ''
        }
        this.updateTextDiagramObject = this.updateTextDiagramObject.bind(this);

        this.changetextHandler = this.changetextHandler.bind(this);
    }

    componentDidMount(){
        TextDiagramObjectService.getTextDiagramObjectById(this.state.id).then( (res) =>{
            let textDiagramObject = res.data;
            this.setState({
                text: textDiagramObject.text
            });
        });
    }

    updateTextDiagramObject = (e) => {
        e.preventDefault();
        let textDiagramObject = {
            textDiagramObjectId: this.state.id,
            text: this.state.text
        };
        console.log('textDiagramObject => ' + JSON.stringify(textDiagramObject));
        console.log('id => ' + JSON.stringify(this.state.id));
        TextDiagramObjectService.updateTextDiagramObject(textDiagramObject).then( res => {
            this.props.history.push('/textDiagramObjects');
        });
    }

    changetextHandler= (event) => {
        this.setState({text: event.target.value});
    }

    cancel(){
        this.props.history.push('/textDiagramObjects');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update TextDiagramObject</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                            <label> text: </label>
                                            #formFields( $attribute, 'update')
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateTextDiagramObject}>Save</button>
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

export default UpdateTextDiagramObjectComponent
