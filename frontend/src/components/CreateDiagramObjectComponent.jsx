import React, { Component } from 'react'
import DiagramObjectService from '../services/DiagramObjectService';

class CreateDiagramObjectComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            // step 2
            id: this.props.match.params.id,
                drawingOrder: '',
                isPolygon: '',
                offsetX: '',
                offsetY: '',
                rotation: ''
        }
        this.changedrawingOrderHandler = this.changedrawingOrderHandler.bind(this);
        this.changeisPolygonHandler = this.changeisPolygonHandler.bind(this);
        this.changeoffsetXHandler = this.changeoffsetXHandler.bind(this);
        this.changeoffsetYHandler = this.changeoffsetYHandler.bind(this);
        this.changerotationHandler = this.changerotationHandler.bind(this);
    }

    // step 3
    componentDidMount(){

        // step 4
        if(this.state.id === '_add'){
            return
        }else{
            DiagramObjectService.getDiagramObjectById(this.state.id).then( (res) =>{
                let diagramObject = res.data;
                this.setState({
                    drawingOrder: diagramObject.drawingOrder,
                    isPolygon: diagramObject.isPolygon,
                    offsetX: diagramObject.offsetX,
                    offsetY: diagramObject.offsetY,
                    rotation: diagramObject.rotation
                });
            });
        }        
    }
    saveOrUpdateDiagramObject = (e) => {
        e.preventDefault();
        let diagramObject = {
                diagramObjectId: this.state.id,
                drawingOrder: this.state.drawingOrder,
                isPolygon: this.state.isPolygon,
                offsetX: this.state.offsetX,
                offsetY: this.state.offsetY,
                rotation: this.state.rotation
            };
        console.log('diagramObject => ' + JSON.stringify(diagramObject));

        // step 5
        if(this.state.id === '_add'){
            diagramObject.diagramObjectId=''
            DiagramObjectService.createDiagramObject(diagramObject).then(res =>{
                this.props.history.push('/diagramObjects');
            });
        }else{
            DiagramObjectService.updateDiagramObject(diagramObject).then( res => {
                this.props.history.push('/diagramObjects');
            });
        }
    }
    
    changedrawingOrderHandler= (event) => {
        this.setState({drawingOrder: event.target.value});
    }
    changeisPolygonHandler= (event) => {
        this.setState({isPolygon: event.target.value});
    }
    changeoffsetXHandler= (event) => {
        this.setState({offsetX: event.target.value});
    }
    changeoffsetYHandler= (event) => {
        this.setState({offsetY: event.target.value});
    }
    changerotationHandler= (event) => {
        this.setState({rotation: event.target.value});
    }

    cancel(){
        this.props.history.push('/diagramObjects');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add DiagramObject</h3>
        }else{
            return <h3 className="text-center">Update DiagramObject</h3>
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
                                            <label> drawingOrder: </label>
                                            #formFields( $attribute, 'create')
                                            <label> isPolygon: </label>
                                            #formFields( $attribute, 'create')
                                            <label> offsetX: </label>
                                            #formFields( $attribute, 'create')
                                            <label> offsetY: </label>
                                            #formFields( $attribute, 'create')
                                            <label> rotation: </label>
                                            #formFields( $attribute, 'create')
                                        </div>

                                        <button className="btn btn-success" onClick={this.saveOrUpdateDiagramObject}>Save</button>
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

export default CreateDiagramObjectComponent
