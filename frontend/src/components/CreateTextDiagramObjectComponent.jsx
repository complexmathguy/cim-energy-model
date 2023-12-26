import React, { Component } from 'react'
import TextDiagramObjectService from '../services/TextDiagramObjectService';

class CreateTextDiagramObjectComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            // step 2
            id: this.props.match.params.id,
                text: ''
        }
        this.changetextHandler = this.changetextHandler.bind(this);
    }

    // step 3
    componentDidMount(){

        // step 4
        if(this.state.id === '_add'){
            return
        }else{
            TextDiagramObjectService.getTextDiagramObjectById(this.state.id).then( (res) =>{
                let textDiagramObject = res.data;
                this.setState({
                    text: textDiagramObject.text
                });
            });
        }        
    }
    saveOrUpdateTextDiagramObject = (e) => {
        e.preventDefault();
        let textDiagramObject = {
                textDiagramObjectId: this.state.id,
                text: this.state.text
            };
        console.log('textDiagramObject => ' + JSON.stringify(textDiagramObject));

        // step 5
        if(this.state.id === '_add'){
            textDiagramObject.textDiagramObjectId=''
            TextDiagramObjectService.createTextDiagramObject(textDiagramObject).then(res =>{
                this.props.history.push('/textDiagramObjects');
            });
        }else{
            TextDiagramObjectService.updateTextDiagramObject(textDiagramObject).then( res => {
                this.props.history.push('/textDiagramObjects');
            });
        }
    }
    
    changetextHandler= (event) => {
        this.setState({text: event.target.value});
    }

    cancel(){
        this.props.history.push('/textDiagramObjects');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add TextDiagramObject</h3>
        }else{
            return <h3 className="text-center">Update TextDiagramObject</h3>
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
                                            <label> text: </label>
                                            #formFields( $attribute, 'create')
                                        </div>

                                        <button className="btn btn-success" onClick={this.saveOrUpdateTextDiagramObject}>Save</button>
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

export default CreateTextDiagramObjectComponent
